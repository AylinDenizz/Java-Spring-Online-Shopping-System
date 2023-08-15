package com.allianz.example.util;


import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


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


    public DTO save(RequestDTO dto) {
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

       /* //Pageable pageable = PageRequest.of(1,10,Sort.by("id").descending());

        Pageable pageable = null;
        if (dto != null) {

            if(dto.getSortDTO().getDirection().equals(Sort.Direction.ASC)) {
                pageable = PageRequest.of(dto.getPageNumber(),dto.getPageSize(), Sort.by(dto.getSortDTO().
                        getColoumnName()).ascending());
            } else {
                pageable = PageRequest.of(dto.getPageNumber(),dto.getPageSize(), Sort.by(dto.getSortDTO().
                        getColoumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(dto.getPageNumber(),dto.getPageSize(), Sort.by("id")
                    .ascending());
        }
        Page<Entity> entityPage = getRepository().findAll(pageable);
        return getMapper().pageEntityToPageDTO(entityPage);
    }
*/

        public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
            Pageable pageable = null;
            if (baseFilterRequestDTO.getSortDTO() != null) {
                if (baseFilterRequestDTO.getSortDTO().getDirection() == Sort.Direction.DESC) {
                    pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),
                            baseFilterRequestDTO.getPageSize(),
                            Sort.by(baseFilterRequestDTO.getSortDTO().getColoumnName()).descending());
                } else {
                    pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),
                            baseFilterRequestDTO.getPageSize(),
                            Sort.by(baseFilterRequestDTO.getSortDTO().getColoumnName()).ascending());
                }
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by("id").ascending());
            }
            Page<Entity> entityPage = getRepository().findAll(pageable);
            return getMapper().pageEntityToPageDTO(entityPage);
        }

    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getMapper().entityToDTO(getRepository().save(getMapper().requestDTOToExistEntity(requestDTO, entity)));
    }


    public Boolean deleteByUuid(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return false;
        }
        getRepository().delete(entity);
        return true;
    }

    public DTO getByUuid(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getMapper().entityToDTO(entity);
    }
}
