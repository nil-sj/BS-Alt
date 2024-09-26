package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.ReviewDTO;
import com.bookself.bookself_api.mappers.ReviewMapper;
import com.bookself.bookself_api.models.Review;
import com.bookself.bookself_api.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.findReviewById(id);
        return review.map(ReviewMapper::toDTO).orElse(null);
    }

    @PostMapping
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = ReviewMapper.toEntity(reviewDTO);
        return ReviewMapper.toDTO(reviewService.saveReview(review));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
