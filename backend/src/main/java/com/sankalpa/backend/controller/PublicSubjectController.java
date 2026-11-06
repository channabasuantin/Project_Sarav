package com.sankalpa.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankalpa.backend.dto.SubjectResponse;
import com.sankalpa.backend.service.SubjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/subjects")
@RequiredArgsConstructor
public class PublicSubjectController {
    private final SubjectService service;

    @GetMapping
    public List<SubjectResponse> list() {
        return service.findAll();
    }
}

