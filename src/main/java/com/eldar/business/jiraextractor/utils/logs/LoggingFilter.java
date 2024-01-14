package com.eldar.business.jiraextractor.utils.logs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Value("${filter.logging.enabled:false}")
    private boolean isFilterEnabled;

    // Lista de URI que deseas omitir del filtro
    private List<String> excludedUris = Arrays.asList("/actuator/health", "/actuator", "/actuator/info");
    private List<String> excludedPatterns = Arrays.asList("/swagger", "/v3/api-docs");


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if(!isFilterEnabled) {
            filterChain.doFilter(request,response);
            return;
        }

        // Obten la URI actual
        String requestUri = request.getRequestURI();

        // Verifica si la URI está en la lista de omitidas
        if (isUriExcluded(requestUri)) {
            filterChain.doFilter(request, response);
            return;
        }

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        final long startTime = System.currentTimeMillis();

        filterChain.doFilter(requestWrapper, responseWrapper);
        final long timeTaken = System.currentTimeMillis() - startTime;
        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding());
        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),
                response.getCharacterEncoding());

        String method = request.getMethod();
        String queryString = request.getQueryString();
        String remoteAddress =request.getRemoteAddr();
        String sec_ch_ua = request.getHeader("sec-ch-ua");
        String user_Agent = request.getHeader("User-Agent");
        String sec_ch_ua_platform = request.getHeader("sec-ch-ua-platform");
        String sec_ch_ua_mobile = request.getHeader("sec-ch-ua-mobile");
        String host = request.getHeader("Host");
        String authorization = request.getHeader("Authorization");
        String responseCode = String.valueOf(response.getStatus());
        String headersNames = response.getHeaderNames().toString();
        String content_Type = response.getHeaders("Content-Type").toString();

        try {
            MDC.put("httpMethod", method);
            MDC.put("queryString", queryString);
            MDC.put("remoteAddress", remoteAddress);
            MDC.put("sec_ch_ua", sec_ch_ua);
            MDC.put("user_Agent", user_Agent);
            MDC.put("sec_ch_ua_platform", sec_ch_ua_platform);
            MDC.put("sec_ch_ua_mobile", sec_ch_ua_mobile);
            MDC.put("host", host);
            MDC.put("authorization", authorization);
            MDC.put("requestUri", requestUri);
            MDC.put("requestPayload", requestBody);
            MDC.put("responseCode", responseCode);
            MDC.put("headersNames", headersNames);
            MDC.put("responseBody", responseBody);
            MDC.put("content_Type", content_Type);
            MDC.put("timetaken", String.valueOf(timeTaken));

            System.out.println();

            log.info("Sensible Data: Like Payload and ResonseBody only visible inside each container (/logs/<micro-service>.log  \n");
        }finally {
            // Limpiar los custom fields después de completar la solicitud
            MDC.clear();
        }

        responseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean isUriExcluded(String requestUri) {
        return excludedUris.contains(requestUri) || excludedPatterns.stream().anyMatch(requestUri::startsWith);
    }

}