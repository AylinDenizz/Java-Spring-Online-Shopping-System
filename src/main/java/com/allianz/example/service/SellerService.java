package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.SellerSpesification;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SellerService extends BaseService<SellerDTO, SellerEntity, SellerRequestDTO,
        SellerEntityRepository, SellerMapper, SellerSpesification> {
    @Autowired
    SellerEntityRepository sellerRepository;
    @Autowired
    SellerMapper sellerMapper;

    @Override
    protected SellerMapper getMapper() {
        return sellerMapper;
    }

    @Override
    protected SellerEntityRepository getRepository() {
        return sellerRepository;
    }

    @Autowired
    SellerSpesification sellerSpesification;

    @Override
    protected SellerSpesification getSpecification() {
        return sellerSpesification;
    }


    @Override
    public SellerDTO save(SellerRequestDTO sellerRequestDTO) {
        SellerEntity seller = sellerMapper.requestDTOToEntity(sellerRequestDTO);
        sellerRepository.save(seller);
        return sellerMapper.entityToDTO(seller);
    }

    @Override
    public SellerDTO update(UUID uuid, SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return null;
        }
        return sellerMapper.entityToDTO(sellerRepository.save(sellerMapper.requestDTOToExistEntity(sellerRequestDTO, sellerEntity)));
    }

    @Override
    public Boolean deleteByUuid(UUID uuid) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return false;
        }
        sellerRepository.delete(sellerEntity);
        return true;
    }

    @Override
    public SellerDTO getByUuid(UUID uuid) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return null;
        }
        return sellerMapper.entityToDTO(sellerEntity);
    }
}
