package com.allianz.example.util;

import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDto extends BaseDTO,
        Repository extends BaseRepository<Entity>,
        Mapper extends BaseMapper<DTO, Entity, RequestDto>,
        Specification extends BaseSpecification<Entity>,
        Service extends BaseService<DTO, Entity, RequestDto,Repository, Mapper , Specification>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageDTO<DTO>> getALL(@RequestBody BaseFilterRequestDTO dto
                                                            ) {
        return new ResponseEntity<>(getService().getAll(dto), HttpStatus.OK);
    }


    @PutMapping("/{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDto requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid) {
        if (getService().getByUuid(uuid) != null) {
            return new ResponseEntity<>(getService().getByUuid(uuid), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}