package com.allianz.example.controller;

import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.database.specification.SettingSpesification;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.service.SettingService;
import com.allianz.example.service.SettingService;
import com.allianz.example.util.BaseController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<SettingEntity, SettingDTO, SettingRequestDTO,
        SettingEntityRepository, SettingMapper, SettingSpesification, SettingService> {
    @Autowired
    SettingService settingService;

    @Autowired
    SettingMapper settingMapper;

    @Autowired
    SettingEntityRepository settingsRepository;


    @Override
    protected SettingService getService() {
        return settingService;
    }


}
