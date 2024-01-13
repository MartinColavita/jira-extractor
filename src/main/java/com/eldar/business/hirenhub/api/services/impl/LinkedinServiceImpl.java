package com.eldar.business.hirenhub.api.services.impl;

import com.eldar.business.hirenhub.api.services.contracts.LinkedinService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class LinkedinServiceImpl implements LinkedinService {

    private static final String JSON_FILE_PATH = "mockups/Linkedin_mock.json";

    @Override
    public String getLinkedin() {
        try {
            // Lee el contenido del archivo JSON desde el classpath
            ClassPathResource resource = new ClassPathResource(JSON_FILE_PATH);
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String jsonFromFile = new String(bytes);

            // Convierte el JSON a un objeto Java (JsonNode en este caso)
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonObject = objectMapper.readTree(jsonFromFile);
            String loginStatus = jsonObject.at("/Accounts/LoginStatus").asText();

            // Devuelve el JSON o los datos específicos según sea necesario
            return jsonObject.toString();
        } catch (IOException e) {
            e.printStackTrace();
            // Maneja la excepción según tus necesidades
            return "Error al leer el archivo JSON";
        }
    }

}
