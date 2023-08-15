package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.SettingDTO;

import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


@Component
public class SettingMapper implements BaseMapper<SettingDTO, SettingEntity, SettingRequestDTO> {
    @Override
    public SettingDTO entityToDTO(SettingEntity entity) {
        SettingDTO dto = new SettingDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());

        return dto;
    }

    @Override
    public SettingEntity dtoToEntity(SettingDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());

        return entity;
    }

    @Override
    public List<SettingDTO> entityListToDTOList(List<SettingEntity> settingEntities) {
        List<SettingDTO> dtoList = new ArrayList<>();
        for (SettingEntity entity : settingEntities) {
            SettingDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<SettingEntity> dtoListTOEntityList(List<SettingDTO> settingDTOS) {
        List<SettingEntity> dtoList = new ArrayList<>();
        for (SettingDTO dto : settingDTOS) {
            SettingEntity entity = dtoToEntity(dto);
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public SettingEntity requestDTOToEntity(SettingRequestDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }

    @Override
    public List<SettingEntity> requestDTOListTOEntityList(List<SettingRequestDTO> settingRequestDTOS) {
        List<SettingEntity> dtoList = new ArrayList<>();
        for (SettingRequestDTO dto : settingRequestDTOS) {
            SettingEntity entity = requestDTOToEntity(dto);
            dtoList.add(entity);
        }
        return dtoList;

    }

    @Override
    public SettingEntity requestDTOToExistEntity(SettingRequestDTO dto, SettingEntity entity) {
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }

    @Override
    public PageDTO<SettingDTO> pageEntityToPageDTO(Page<SettingEntity> settingEntities) {
        PageDTO<SettingDTO> settingsPageDTO = new PageDTO<>();
        settingsPageDTO.setTotalPages(settingEntities.getTotalPages());
        settingsPageDTO.setSize(settingEntities.getSize());
        settingsPageDTO.setContent(entityListToDTOList(settingEntities.getContent()));
        settingsPageDTO.setNumber(settingEntities.getNumber());
        settingsPageDTO.setTotalElements(settingEntities.getTotalElements());
        settingsPageDTO.setNumberOfElement(settingEntities.getNumberOfElements());
        settingsPageDTO.setSort(settingEntities.getSort());

        return settingsPageDTO;
    }
}