package com.sankalpa.backend.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sankalpa.backend.dto.MaterialResponse;
import com.sankalpa.backend.entity.Material;
import com.sankalpa.backend.exception.ResourceNotFoundException;
import com.sankalpa.backend.repository.MaterialRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository repository;

    @Transactional(readOnly = true)
    public List<MaterialResponse> search(String subjectSlug, Integer day, String topic) {
        return repository.search(subjectSlug, day, topic).stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public MaterialResponse findById(Long id) {
        return repository.findByIdAndPublishedTrue(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Material not found: " + id));
    }

    private MaterialResponse toResponse(Material m) {
        return new MaterialResponse(m.getId(), m.getSubject().getSlug(), m.getDayNumber(),
                m.getTopic(), m.getTitle(), m.getContentType(), m.getFileSizeBytes());
    }
}
