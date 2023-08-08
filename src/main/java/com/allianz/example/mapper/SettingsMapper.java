package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.Settings;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;

import java.util.ArrayList;
import java.util.List;

public class SettingsMapper implements IBaseMapper<SettingsDTO, Settings, SettingsRequestDTO> {
    @Override
    public SettingsDTO entityToDTO(Settings entity) {
        SettingsDTO settings = new SettingsDTO();
        settings.setUuid(entity.getUuid());
        settings.setCreationDate(entity.getCreationDate());
        settings.setId(entity.getId());
        settings.setUpdatedDate(entity.getUpdatedDate());
        settings.setKey(entity.getKey());
        settings.setValue(entity.getValue());

        return settings;
    }

    @Override
    public Settings dtoToEntity(SettingsDTO dto) {
        Settings settings = new Settings();
        settings.setUuid(dto.getUuid());
        settings.setCreationDate(dto.getCreationDate());
        settings.setId(dto.getId());
        settings.setUpdatedDate(dto.getUpdatedDate());
        settings.setKey(dto.getKey());
        settings.setValue(dto.getValue());

        return settings;
    }

    @Override
    public List<SettingsDTO> entityListToDTOList(List<Settings> settings) {
        List<SettingsDTO> dtos = new ArrayList<>();
        for (Settings entity: settings) {
            dtos.add(entityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public List<Settings> dtoListTOEntityList(List<SettingsDTO> settingsDTOS) {
        List<Settings> entities = new ArrayList<>();
        for (SettingsDTO dto: settingsDTOS) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public Settings requestDTOToEntity(SettingsRequestDTO dto) {

        Settings settings = new Settings();
        settings.setKey(dto.getKey());

        return settings;
    }
}
