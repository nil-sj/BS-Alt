package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.ReadingProgress;
import com.bookself.bookself_api.repositories.ReadingProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadingProgressService {

    private final ReadingProgressRepository readingProgressRepository;

    public ReadingProgressService(ReadingProgressRepository readingProgressRepository) {
        this.readingProgressRepository = readingProgressRepository;
    }

    public Optional<ReadingProgress> findReadingProgressById(Long id) {
        return readingProgressRepository.findById(id);
    }

    public ReadingProgress saveReadingProgress(ReadingProgress readingProgress) {
        return readingProgressRepository.save(readingProgress);
    }

    public void deleteReadingProgress(Long id) {
        readingProgressRepository.deleteById(id);
    }
}
