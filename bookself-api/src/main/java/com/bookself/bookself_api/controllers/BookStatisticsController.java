package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.BookStatisticsDTO;
import com.bookself.bookself_api.mappers.BookStatisticsMapper;
import com.bookself.bookself_api.models.BookStatistics;
import com.bookself.bookself_api.services.BookStatisticsService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book-statistics")
public class BookStatisticsController {

    private final BookStatisticsService bookStatisticsService;

    public BookStatisticsController(BookStatisticsService bookStatisticsService) {
        this.bookStatisticsService = bookStatisticsService;
    }

    @GetMapping("/{id}")
    public BookStatisticsDTO getBookStatisticsById(@PathVariable Long id) {
        Optional<BookStatistics> stats = bookStatisticsService.findBookStatisticsById(id);
        return stats.map(BookStatisticsMapper::toDTO).orElse(null);
    }

    @PostMapping
    public BookStatisticsDTO createBookStatistics(@RequestBody BookStatisticsDTO statsDTO) {
        BookStatistics stats = BookStatisticsMapper.toEntity(statsDTO);
        return BookStatisticsMapper.toDTO(bookStatisticsService.saveBookStatistics(stats));
    }

    @DeleteMapping("/{id}")
    public void deleteBookStatistics(@PathVariable Long id) {
        bookStatisticsService.deleteBookStatistics(id);
    }
}
