package com.allianz.example.mapper;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;

import com.allianz.example.util.BaseMapper;
import com.allianz.example.util.PageDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentMapper implements BaseMapper<CommentDTO, CommentEntity, CommentRequestDTO> {
    @Override
    public CommentDTO entityToDTO(CommentEntity entity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUuid(entity.getUuid());
        commentDTO.setId(entity.getId());
        commentDTO.setCreationDate(entity.getCreationDate());
        commentDTO.setUpdatedDate(entity.getUpdatedDate());

        return commentDTO;

    }

    @Override
    public CommentEntity dtoToEntity(CommentDTO dto) {
        CommentEntity comment = new CommentEntity();
        comment.setUuid(dto.getUuid());
        comment.setId(dto.getId());
        comment.setCreationDate(dto.getCreationDate());
        comment.setUpdatedDate(dto.getUpdatedDate());
        return comment;

    }

    @Override
    public CommentEntity requestDTOToExistEntity(CommentRequestDTO dto, CommentEntity entity) {
        return null;
    }

    @Override
    public List<CommentDTO> entityListToDTOList(List<CommentEntity> commentEntities) {
        return null;
    }

    @Override
    public List<CommentEntity> dtoListTOEntityList(List<CommentDTO> commentDTOS) {
        return null;
    }

    @Override
    public CommentEntity requestDTOToEntity(CommentRequestDTO dto) {
        return null;
    }

    @Override
    public List<CommentEntity> requestDTOListTOEntityList(List<CommentRequestDTO> commentRequestDTOS) {
        return null;
    }

    @Override
    public PageDTO<CommentDTO> pageEntityToPageDTO(Page<CommentEntity> entities) {
        PageDTO<CommentDTO>  pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(entities.getTotalPages());
        pageDTO.setSize(entities.getSize());
        pageDTO.setContent(entityListToDTOList(entities.getContent()));
        pageDTO.setNumber(entities.getNumber());
        pageDTO.setTotalElements(entities.getTotalElements());
        pageDTO.setNumberOfElement(entities.getNumberOfElements());
        pageDTO.setSort(entities.getSort());

        return  pageDTO;
    }
}
