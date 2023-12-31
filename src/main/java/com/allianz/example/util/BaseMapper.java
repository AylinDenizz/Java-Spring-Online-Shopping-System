package com.allianz.example.util;

import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> requestDTOListTOEntityList(List<RequestDTO> dtoList);

    Entity requestDTOToExistEntity(RequestDTO dto, Entity entity);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);




}
