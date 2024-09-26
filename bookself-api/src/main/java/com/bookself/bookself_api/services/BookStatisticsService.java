package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.BookStatistics;
import com.bookself.bookself_api.repositories.BookStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookStatisticsService {

    private final BookStatisticsRepository bookStatisticsRepository;

    public BookStatisticsService(BookStatisticsRepository bookStatisticsRepository) {
        this.bookStatisticsRepository = bookStatisticsRepository;
    }

    public Optional<BookStatistics> findBookStatisticsById(Long id) {
        return bookStatisticsRepository.findById(id);
    }

    public BookStatistics saveBookStatistics(BookStatistics bookStatistics) {
        return bookStatisticsRepository.save(bookStatistics);
    }

    public void deleteBookStatistics(Long id) {
        bookStatisticsRepository.deleteById(id);
    }
}
