package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.BookStatisticsDTO;
import com.bookself.bookself_api.models.BookStatistics;

public class BookStatisticsMapper {

    public static BookStatisticsDTO toDTO(BookStatistics bookStatistics) {
        BookStatisticsDTO dto = new BookStatisticsDTO();
        dto.setId(bookStatistics.getId());
        dto.setTimesRead(bookStatistics.getTimesRead());
        dto.setAverageRating(bookStatistics.getAverageRating());
        dto.setTotalReviews(bookStatistics.getTotalReviews());
        return dto;
    }

    public static BookStatistics toEntity(BookStatisticsDTO dto) {
        BookStatistics bookStatistics = new BookStatistics();
        bookStatistics.setId(dto.getId());
        bookStatistics.setTimesRead(dto.getTimesRead());
        // Other fields can be set based on requirements
        return bookStatistics;
    }
}

