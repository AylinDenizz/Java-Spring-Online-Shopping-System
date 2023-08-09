package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class SellerService extends BaseDTO {

    @Autowired
    SellerEntityRepository sellerEntityRepository;
    @Autowired
    SellerMapper sellerMapper;
    public SellerDTO create(SellerDTO sellerDTO) {
        SellerEntity seller = sellerMapper.dtoToEntity(sellerDTO);
        sellerEntityRepository.save(seller);
        return sellerMapper.entityToDTO(seller);
    }

    public List<SellerDTO> getAll() {
        List<SellerEntity> sellerEntities = sellerEntityRepository.findAll();
        return sellerMapper.entityListToDTOList(sellerEntities);
    }

    public SellerDTO getByUUID(UUID uuid) {
        SellerDTO sellerDTO = sellerMapper.entityToDTO(sellerEntityRepository.findByUuid(uuid).get());
        return sellerDTO;
    }
}
