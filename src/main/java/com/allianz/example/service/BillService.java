package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;

import com.allianz.example.model.BillDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BillService {
    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    public BillDTO create(BillDTO dto) {
        BillEntity billEntity = billMapper.dtoToEntity(dto);
        billEntityRepository.save(billEntity);

        return billMapper.entityToDTO(billEntity);

    }

    public List<BillDTO> getAll() {
        List<BillEntity> billEntityList =  billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntityList);
    }

    public BillDTO getByUUID(UUID uuid) {
        Optional<BillEntity> billEntity = billEntityRepository.findByUuid(uuid);
        if (billEntity != null) {
            return billMapper.entityToDTO(billEntity.get());
        }
        else {
            return null;
        }
    }


}
