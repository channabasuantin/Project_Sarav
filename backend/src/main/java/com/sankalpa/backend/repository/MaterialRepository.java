package com.sankalpa.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sankalpa.backend.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query("""
        select m from Material m join fetch m.subject s
        where m.published = true
          and (:subjectSlug is null or s.slug = :subjectSlug)
          and (:day is null or m.dayNumber = :day)
          and (:topic is null or m.topic = :topic)
        order by m.dayNumber, m.id
        """)
    List<Material> search(@Param("subjectSlug") String subjectSlug,
                          @Param("day") Integer day,
                          @Param("topic") String topic);

    @EntityGraph(attributePaths = "subject")
    Optional<Material> findByIdAndPublishedTrue(Long id);
}

