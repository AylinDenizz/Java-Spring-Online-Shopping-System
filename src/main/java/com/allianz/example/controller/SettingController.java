package com.allianz.example.controller;

import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.service.SettingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("setting")
public class SettingController {
    @Autowired
    SettingService settingService;

    @Autowired
    SettingMapper settingMapper;

    @Autowired
    SettingEntityRepository settingsRepository;

    @PostMapping("")
    public ResponseEntity<SettingDTO> save(@RequestBody SettingRequestDTO settingRequestDTO) {
        return new ResponseEntity<>(settingService.create(settingRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<SettingDTO>> getAll() {
        return new ResponseEntity<>(settingService.getAll(), HttpStatus.OK);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<SettingDTO> update(@PathVariable UUID uuid, @RequestBody SettingRequestDTO settingRequestDTO) {
        if (settingService.update(uuid, settingRequestDTO) != null) {
            return new ResponseEntity<>(settingService.update(uuid, settingRequestDTO), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = settingService.deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<SettingDTO> getByUUID(@PathVariable UUID uuid) {
        SettingDTO settingDTO = settingService.getByUUID(uuid);

        if (settingDTO != null) {

            return new ResponseEntity<>(settingDTO, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

}
