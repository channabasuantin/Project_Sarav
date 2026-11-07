package com.sankalpa.backend.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "materials")
@Getter
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "day_number")
    private int dayNumber;
    private String topic;
    private String title;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "object_key")
    private String objectKey;
    @Column(name = "file_size_bytes")
    private long fileSizeBytes;
    private boolean published;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
