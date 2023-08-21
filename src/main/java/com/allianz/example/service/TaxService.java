package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.TaxSpesification;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RestController
public class TaxService extends BaseService<TaxDTO, TaxEntity, TaxRequestDTO, TaxEntityRepository, TaxMapper,
        TaxSpesification> {
    @Autowired
    TaxEntityRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    @Autowired
    TaxSpesification taxSpesification;

    @Override
    protected TaxMapper getMapper() {
        return  taxMapper;
    }

    @Override
    protected TaxEntityRepository getRepository() {
       return taxEntityRepository;
    }

    @Override
    protected TaxSpesification getSpecification() {
        return taxSpesification;
    }

    @Override
    public TaxDTO save(TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = taxMapper.requestDTOToEntity(taxRequestDTO);
        taxEntityRepository.save(taxEntity);
        return taxMapper.entityToDTO(taxEntity);
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {

        TaxEntity taxEntity = taxEntityRepository.findByUuid(uuid).orElse(null);

        if(taxEntity != null){
            taxEntity = taxMapper.requestDTOToExistEntity(taxRequestDTO, taxEntity);
            taxEntityRepository.save(taxEntity);
            return taxMapper.entityToDTO(taxEntity);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        Optional<TaxEntity> taxEntity = taxEntityRepository.findByUuid(uuid);
        if(taxEntity.isPresent()){
            taxEntityRepository.delete(taxEntity.get());
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    @Override
    public TaxDTO getByUuid(UUID uuid) {
        Optional<TaxEntity> taxEntity = taxEntityRepository.findByUuid(uuid);
        if(taxEntity.isPresent()){
            return taxMapper.entityToDTO(taxEntity.get());
        } else {
            return null;
        }
    }



}

