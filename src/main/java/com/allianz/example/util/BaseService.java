package com.allianz.example.util;

import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.util.dbutil.BaseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;


import java.util.List;
import java.util.UUID;

public abstract class BaseService<
        DTO extends BaseDTO,
        Entity extends BaseEntity,
        RequestDTO extends BaseDTO,
        Repository extends BaseRepository<Entity>,
        Mapper extends BaseMapper<DTO, Entity, RequestDTO>> {

    protected abstract Mapper getMapper();
    protected abstract Repository getRepository();



    public DTO save(RequestDTO dto){
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);


    }

    public PageDTO<DTO> getAll(int pageNumber, int size){
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by("id").descending());
        List<Entity> sellerEntities = getRepository().findAll();
        Page<Entity> entityPage = getRepository().findAll(pageable);
        return getMapper().pageEntityToPageDTO(entityPage);
    }

    public abstract List<TaxDTO> getAll();

    public DTO update(UUID uuid, RequestDTO requestDTO){
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getMapper().entityToDTO(getRepository().save(getMapper().requestDTOToExistEntity(requestDTO, entity)));
    }


    public Boolean deleteByUuid(UUID uuid){
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return false;
        }
        getRepository().delete(entity);
        return true;
    }

    public DTO getByUuid(UUID uuid){
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getMapper().entityToDTO(entity);
    }
}
