package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.ReadingProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {
}

