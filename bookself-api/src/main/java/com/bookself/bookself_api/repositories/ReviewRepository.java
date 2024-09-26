package com.bookself.bookself_api.repositories;

import com.bookself.bookself_api.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

