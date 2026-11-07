package com.sankalpa.backend.dto;

public record MaterialResponse(Long id, String subjectSlug, int dayNumber, String topic,
                               String title, String contentType, long fileSizeBytes) {}
