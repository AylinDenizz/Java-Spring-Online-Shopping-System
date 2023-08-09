package com.allianz.example.controller;

import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.SettingsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController {
    @Autowired
    SettingsService settingsService;

    @Autowired
    SettingsMapper settingsMapper;

    @PostMapping("create")
    public ResponseEntity<SettingsDTO> save(@RequestBody SettingsRequestDTO settingsRequestDTO) {
        return new ResponseEntity<>(settingsService.create(settingsRequestDTO), HttpStatus.CREATED);
    }
}
