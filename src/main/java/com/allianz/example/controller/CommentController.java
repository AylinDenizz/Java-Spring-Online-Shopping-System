package com.allianz.example.controller;

import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.repository.CommentEntityRepository;
import com.allianz.example.mapper.CommentMapper;
import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.service.CommentService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("CommentDTO")
public class CommentController extends BaseController<CommentEntity, CommentDTO, CommentRequestDTO, CommentEntityRepository, CommentMapper, CommentService> {



    @Autowired
    CommentService CommentService;

    @Autowired
    CommentMapper CommentMapper;

    @Override
    protected CommentService getService() {
        return CommentService;
    }
}