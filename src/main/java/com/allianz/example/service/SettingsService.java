package com.allianz.example.service;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.database.repository.SettingsRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class SettingsService extends BaseDTO {
    @Autowired
    SettingsRepository settingsRepository;

    @Autowired
    SettingsMapper settingsMapper;

    public SettingsDTO create(SettingsRequestDTO settingsRequestDTO) {
        Settings settings = settingsMapper.requestDTOToEntity(settingsRequestDTO);
        settingsRepository.save(settings);
        return settingsMapper.entityToDTO(settings);
    }

    public List<SettingsDTO> getAll() {
        List<Settings> settingsEntityList = settingsRepository.findAll();
        return settingsMapper.entityListToDTOList(settingsEntityList);
    }

    public SettingsDTO getByUUID(UUID uuid) {
        SettingsDTO settingsDTO = settingsMapper.entityToDTO(settingsRepository.findByUuid(uuid).get());
        return settingsDTO;
    }
}
