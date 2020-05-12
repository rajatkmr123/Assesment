package com.rajat.assessment.controller;

import com.rajat.assessment.dto.ConfigDTO;
import com.rajat.assessment.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ConfigController {
    @GetMapping("/api/getConfigDetails")
    public ResponseEntity<List<ConfigDTO>> getConfigDetails() {
        final List<ConfigDTO> configDTOS = new ArrayList<>();
        IntStream.range(1, 10).forEach(e -> {
                    final ConfigDTO configDTO = new ConfigDTO();
                    configDTO.setId((long) e);
                    configDTO.setSettings("settings_" + e);

                    configDTOS.add(configDTO);
                }
        );
        return ResponseEntity.status(HttpStatus.OK).body(configDTOS);
    }
}
