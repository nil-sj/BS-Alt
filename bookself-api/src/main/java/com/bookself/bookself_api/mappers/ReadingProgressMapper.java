package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.ReadingProgressDTO;
import com.bookself.bookself_api.models.ReadingProgress;

public class ReadingProgressMapper {

    public static ReadingProgressDTO toDTO(ReadingProgress readingProgress) {
        ReadingProgressDTO dto = new ReadingProgressDTO();
        dto.setId(readingProgress.getId());
        dto.setPagesRead(readingProgress.getPagesRead());
        dto.setTotalPages(readingProgress.getTotalPages());
        dto.setProgressPercentage(readingProgress.getProgressPercentage());
        dto.setStartedDate(readingProgress.getStartedDate());
        dto.setCompletedDate(readingProgress.getCompletedDate());
        dto.setReadingStatus(readingProgress.getReadingStatus().name());
        return dto;
    }

    public static ReadingProgress toEntity(ReadingProgressDTO dto) {
        ReadingProgress readingProgress = new ReadingProgress();
        readingProgress.setId(dto.getId());
        readingProgress.setPagesRead(dto.getPagesRead());
        readingProgress.setTotalPages(dto.getTotalPages());
        // Other fields can be set based on requirements
        return readingProgress;
    }
}

