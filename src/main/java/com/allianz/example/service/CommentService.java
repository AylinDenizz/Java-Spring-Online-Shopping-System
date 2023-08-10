package com.allianz.example.service;


import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.repository.CommentEntityRepository;
import com.allianz.example.mapper.CommentMapper;

import com.allianz.example.model.CommentDTO;
import com.allianz.example.util.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CommentService {
    @Autowired
    CommentEntityRepository commentEntityRepository;

    @Autowired
    CommentMapper commentMapper;

    public CommentDTO create(CommentDTO categoryDTO) {
        CommentEntity comment = commentMapper.dtoToEntity(categoryDTO);
        commentEntityRepository.save(comment);
        return commentMapper.entityToDTO(comment);
    }

    public List<CommentDTO> getAll() {
        List<CommentEntity> commentEntityList = commentEntityRepository.findAll();
        return commentMapper.entityListToDTOList(commentEntityList);
    }

    public CommentDTO getByUUID(UUID uuid) {
        CommentDTO commentDTO = commentMapper.entityToDTO(commentEntityRepository.findByUuid(uuid).get());
        return commentDTO;
    }
}
