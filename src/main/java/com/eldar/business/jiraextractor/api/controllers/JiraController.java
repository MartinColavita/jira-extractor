package com.eldar.business.jiraextractor.api.controllers;

import com.eldar.business.jiraextractor.api.services.contracts.JiraService;
import com.eldar.business.jiraextractor.api.models.mock.UserDataDTO;
import com.eldar.business.jiraextractor.utils.swaggerconf.SwaggerResponseCode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/linkedin")
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "ELDAR - Linkedin")
public class JiraController extends SwaggerResponseCode {

    private final JiraService jiraService;

    /**
     * Start Prototipo: Adaptale a su necesidad
     */
    @GetMapping("/get_mock")
    @Operation(description = "Prototipo GET Mock.", summary = "PONGA LOS DTO'S que CORRESPONDEN en sus metodos")
    public ResponseEntity<Object> get_mock_Linkedin() {
        Object responseBody = jiraService.getLinkedin();
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .header("Mensaje-del-servidor", "Esto es un Mockup hasta poder consultar el Servicio REAL.")  
                .body(responseBody);
    }

    @GetMapping("/get_mock/params/{param1}/{param2}")
    @Operation(description = "Prototipo POST Mock.", summary = "PONGA LOS DTO'S que CORRESPONDEN en sus metodos, solo devuelve el DTO que envio a modo ejemplo. Debera crear el Servicio que cubre esta necesidad")
    @Parameters({@Parameter(name = "param1", description = "Ingrese Nombre"),@Parameter(name = "param2", description = "Ingrese Apellido")})
    public ResponseEntity<?> get_mock_params(@RequestParam(defaultValue = "Nombre") String param1,@RequestParam(defaultValue = "Apellido") String param2) {
        // DEMO Construir el objeto JSON  => Consuma del servicio especifico
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("param1", param1);
        jsonResponse.put("param2", param2);
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .header("Mensaje-del-servidor", "Esto es un Mockup hasta poder consultar el Servicio REAL.")
                .body(jsonResponse);
    }

    @PostMapping("/post_mock")
    @Operation(description = "Prototipo POST Mock.", summary = "PONGA LOS DTO'S que CORRESPONDEN en sus metodos, solo devuelve el DTO que envio a modo ejemplo. Debera crear el Servicio que cubre esta necesidad")
    public ResponseEntity<?> post_mock(@RequestBody UserDataDTO dto) {
        // UserDataDTO user = this.userService.registration(dto); => Consuma del servicio especifico
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .header("Mensaje-del-servidor", "Esto es un Mockup hasta poder consultar el Servicio REAL.")
                .body(dto);
    }

    @PostMapping("/get_mock/params/{param1}/{param2}")
    @Operation(description = "Prototipo POST Mock.", summary = "PONGA LOS DTO'S que CORRESPONDEN en sus metodos, solo devuelve el DTO que envio a modo ejemplo. Debera crear el Servicio que cubre esta necesidad")
    @Parameters({@Parameter(name = "param1", description = "Ingrese Nombre"),@Parameter(name = "param2", description = "Ingrese Apellido")})
    public ResponseEntity<?> post_mock_params(@RequestParam(defaultValue = "Nombre") String param1,@RequestParam(defaultValue = "Apellido") String param2) {
        // DEMO Construir el objeto JSON  => Consuma del servicio especifico
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("param1", param1);
        jsonResponse.put("param2", param2);
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .header("Mensaje-del-servidor", "Esto es un Mockup hasta poder consultar el Servicio REAL.")
                .body(jsonResponse);
    }
    // END Prototipo(EJEMPLO)
}
