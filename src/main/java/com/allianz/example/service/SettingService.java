package com.allianz.example.service;

import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RestController
public class SettingService extends BaseService<SettingDTO, SettingEntity, SettingRequestDTO, SettingEntityRepository, SettingMapper> {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;



    public SettingDTO create(SettingRequestDTO requestDTO) {

        SettingEntity settingEntity = settingMapper.requestDTOToEntity(requestDTO);
        settingEntityRepository.save(settingEntity);
        return settingMapper.entityToDTO(settingEntity);
    }

    @Override
    protected SettingMapper getMapper() {
        return settingMapper;
    }

    @Override
    protected SettingEntityRepository getRepository() {
        return settingEntityRepository;
    }

    public List<SettingDTO> getAll() {
        List<SettingEntity> settingsEntityList = settingEntityRepository.findAll();
        return settingMapper.entityListToDTOList(settingsEntityList);
    }

    public SettingDTO getByUUID(UUID uuid) {
        SettingDTO settingsDTO = settingMapper.entityToDTO(settingEntityRepository.findByUuid(uuid).get());
        return settingsDTO;
    }

    public SettingDTO update(UUID uuid, SettingRequestDTO settingRequestDTO) {
        Optional<SettingEntity> optionalSettingEntity = settingEntityRepository.findByUuid(uuid);
        if (optionalSettingEntity.isPresent()) {
            SettingEntity newSettingEntity = settingMapper.requestDTOToExistEntity(settingRequestDTO, optionalSettingEntity.get());
            settingEntityRepository.save(newSettingEntity);

            return settingMapper.entityToDTO(newSettingEntity);
        } else {
            return null;
        }
    }

    public Boolean deleteByUuid(UUID uuid) {
        Optional<SettingEntity> optionalSettingEntity = settingEntityRepository.findByUuid(uuid);

        if (optionalSettingEntity.isPresent()) {
            settingEntityRepository.delete((optionalSettingEntity.get()));
            return true;
        } else {
            return false;
        }
    }

}
