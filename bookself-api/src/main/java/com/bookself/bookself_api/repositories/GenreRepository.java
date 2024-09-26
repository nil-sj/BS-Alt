package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
