package com.allianz.example.service;


import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CommentEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.database.specification.AddressSpesification;
import com.allianz.example.database.specification.CategorySpesification;
import com.allianz.example.database.specification.CommentSpesification;
import com.allianz.example.mapper.CommentMapper;

import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CommentService extends BaseService<CommentDTO, CommentEntity, CommentRequestDTO,
        CommentEntityRepository, CommentMapper, CommentSpesification> {
    @Autowired
    CommentEntityRepository commentEntityRepository;

    @Autowired
    CommentMapper commentMapper;

    @Override
    protected CommentMapper getMapper() {
        return commentMapper;
    }

    @Autowired
    CommentSpesification commentSpesification;

    @Override
    protected CommentEntityRepository getRepository() {
        return commentEntityRepository;
    }

    @Override
    protected CommentSpesification getSpecification() {
        return commentSpesification;
    }

    public CommentDTO create(CommentDTO categoryDTO) {
        CommentEntity comment = commentMapper.dtoToEntity(categoryDTO);
        commentEntityRepository.save(comment);
        return commentMapper.entityToDTO(comment);
    }

    public List<CommentDTO> getAll() {
        List<CommentEntity> commentEntityList = commentEntityRepository.findAll();
        return commentMapper.entityListToDTOList(commentEntityList);
    }

    public CommentDTO getByUuid(UUID uuid) {
        CommentDTO commentDTO = commentMapper.entityToDTO(commentEntityRepository.findByUuid(uuid).get());
        return commentDTO;
    }
}
