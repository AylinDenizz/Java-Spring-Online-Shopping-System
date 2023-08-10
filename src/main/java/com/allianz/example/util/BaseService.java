package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public abstract class BaseService<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {
    public DTO save(RequestDTO requestDTO){
        return null;
    }

    public List<DTO> getAll(){
        return null;
    }

    public DTO update(UUID uuid, RequestDTO requestDTO){
        return null;
    }


    public Boolean deleteByUuid(UUID uuid){
        return false;
    }

    public DTO getByUuid(UUID uuid){
        return null;
    }
}
