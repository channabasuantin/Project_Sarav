package com.sankalpa.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sankalpa.backend.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByOrderByDisplayOrderAsc();
}