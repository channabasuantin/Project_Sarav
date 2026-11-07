package com.sankalpa.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sankalpa.backend.dto.MaterialResponse;
import com.sankalpa.backend.service.MaterialService;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/materials")
@RequiredArgsConstructor
public class PublicMaterialController {
    private final MaterialService service;

   @GetMapping
public List<MaterialResponse> list(
        @RequestParam(required = false) @Size(max = 100) String subjectSlug,
        @RequestParam(required = false) @Min(1) Integer day,
        @RequestParam(required = false) @Size(max = 255) String topic) {
    return service.search(subjectSlug, day, topic);
}


    @GetMapping("/{id}")
    public MaterialResponse get(@PathVariable Long id) {
        return service.findById(id);
    }
}
