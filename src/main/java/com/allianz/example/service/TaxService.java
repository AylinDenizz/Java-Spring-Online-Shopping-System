package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class TaxService extends BaseDTO {
    @Autowired
    TaxMapper taxMapper;

    @Autowired
    TaxEntityRepository taxEntityRepository;

    public TaxDTO create(TaxDTO taxDTO) {
        TaxEntity entity = taxMapper.dtoToEntity(taxDTO);
        taxEntityRepository.save(entity);

        return taxMapper.entityToDTO(entity);
    }

    public List<TaxDTO> getAll() {
        List<TaxEntity> taxEntityList = taxEntityRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntityList);
    }

    public TaxDTO getByUUID(UUID uuid) {
        TaxDTO taxDTO = taxMapper.entityToDTO(taxEntityRepository.findByUuid(uuid).get());
        return taxDTO;
    }
}

