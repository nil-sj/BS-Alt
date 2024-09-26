package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.ReviewDTO;
import com.bookself.bookself_api.models.Review;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());  // Reference by ID
        dto.setBookId(review.getBook().getId());  // Reference by ID
        dto.setContent(review.getContent());
        dto.setRating(review.getRating());
        dto.setCreatedDate(review.getCreatedDate());
        dto.setUpdatedDate(review.getUpdatedDate());
        return dto;
    }

    public static Review toEntity(ReviewDTO dto) {
        Review review = new Review();
        review.setId(dto.getId());
        // Book and User should be set at the service layer if needed.
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setCreatedDate(dto.getCreatedDate());
        review.setUpdatedDate(dto.getUpdatedDate());
        return review;
    }
}
