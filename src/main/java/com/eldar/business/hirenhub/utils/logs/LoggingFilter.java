package com.eldar.business.hirenhub.utils.logs;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
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
        if (excludedUris.contains(requestUri)) {
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


        StringBuilder cadenaRespuesta1 = new StringBuilder();
        cadenaRespuesta1.append("\n----------------------\n")
                .append(Color.PURPLE +">>>REQUEST CLIENT DATA\n")
                .append(Color.YELLOW + "RemoteAddress: "+ Color.CYAN +request.getRemoteAddr()+"\n")
                .append(Color.YELLOW + "sec-ch-ua: "+ Color.CYAN +request.getHeader("sec-ch-ua")+"\n")
                .append(Color.YELLOW + "User-Agent: "+ Color.CYAN +request.getHeader("User-Agent")+"\n")
                .append(Color.YELLOW  + "sec-ch-ua-platform: "+ Color.CYAN +request.getHeader("sec-ch-ua-platform")+"\n")
                .append(Color.YELLOW + "sec-ch-ua-mobile: "+ Color.CYAN +request.getHeader("sec-ch-ua-mobile")+"\n")
                .append(Color.YELLOW + "Host: "+ Color.CYAN +request.getHeader("Host")+"\n")
                .append(Color.YELLOW + "Metodo: "+ Color.CYAN +request.getMethod()+"\n")
                .append(Color.YELLOW + "Authorization: "+ Color.CYAN +request.getHeader("Authorization")+"\n")
                .append(Color.YELLOW + "RequesUri: "+ Color.CYAN +request.getRequestURI()+"\n")
                .append(Color.YELLOW + "RequesPayload: "+ Color.CYAN +requestBody+"\n")
                .append(Color.PURPLE + ">>>RESPONSE FROM SERVER\n")
                .append(Color.YELLOW + "ResponseCode: "+ Color.GREEN + response.getStatus()+"\n")
                .append(Color.YELLOW + "HeadersNames: "+ Color.GREEN + response.getHeaderNames()+"\n")
                .append(Color.YELLOW + "Mensaje del Servidor: "+ Color.GREEN + response.getHeaders("Mensaje-del-servidor")+"\n")
                .append(Color.YELLOW + "Content-Type: "+ Color.GREEN + response.getHeaders("Content-Type")+"\n")
                .append(Color.YELLOW + "ResponseBody: "+ Color.GREEN + responseBody+"\n")
                .append(Color.YELLOW + "TimeTaken: "+ Color.GREEN + timeTaken + Color.RESET);
        log.warn(cadenaRespuesta1.toString());
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

}
