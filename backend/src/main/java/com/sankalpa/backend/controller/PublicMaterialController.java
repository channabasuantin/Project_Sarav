package com.sankalpa.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sankalpa.backend.dto.MaterialResponse;
import com.sankalpa.backend.service.MaterialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/materials")
@RequiredArgsConstructor
public class PublicMaterialController {
    private final MaterialService service;

    @GetMapping
    public List<MaterialResponse> list(@RequestParam(required = false) String subjectSlug,
                                       @RequestParam(required = false) Integer day,
                                       @RequestParam(required = false) String topic) {
        return service.search(subjectSlug, day, topic);
    }

    @GetMapping("/{id}")
    public MaterialResponse get(@PathVariable Long id) {
        return service.findById(id);
    }
}
