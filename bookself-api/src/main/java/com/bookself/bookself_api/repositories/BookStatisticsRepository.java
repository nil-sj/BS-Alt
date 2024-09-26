package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.BookStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatisticsRepository extends JpaRepository<BookStatistics, Long> {
}

