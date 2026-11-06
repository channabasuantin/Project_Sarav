package com.sankalpa.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sankalpa.backend.dto.SubjectResponse;
import com.sankalpa.backend.repository.SubjectRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

// subject/SubjectService.java
@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository repository;

    @Transactional(readOnly = true)
    public List<SubjectResponse> findAll() {
        return repository.findAllByOrderByDisplayOrderAsc().stream()
                .map(s -> new SubjectResponse(s.getId(), s.getName(), s.getSlug()))
                .toList();
    }
}