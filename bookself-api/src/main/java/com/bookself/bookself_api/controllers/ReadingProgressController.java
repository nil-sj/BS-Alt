package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.ReadingProgressDTO;
import com.bookself.bookself_api.mappers.ReadingProgressMapper;
import com.bookself.bookself_api.models.ReadingProgress;
import com.bookself.bookself_api.services.ReadingProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reading-progress")
public class ReadingProgressController {

    private final ReadingProgressService readingProgressService;

    public ReadingProgressController(ReadingProgressService readingProgressService) {
        this.readingProgressService = readingProgressService;
    }

    @GetMapping("/{id}")
    public ReadingProgressDTO getReadingProgressById(@PathVariable Long id) {
        Optional<ReadingProgress> progress = readingProgressService.findReadingProgressById(id);
        return progress.map(ReadingProgressMapper::toDTO).orElse(null);
    }

    @PostMapping
    public ReadingProgressDTO createReadingProgress(@RequestBody ReadingProgressDTO progressDTO) {
        ReadingProgress progress = ReadingProgressMapper.toEntity(progressDTO);
        return ReadingProgressMapper.toDTO(readingProgressService.saveReadingProgress(progress));
    }

    @DeleteMapping("/{id}")
    public void deleteReadingProgress(@PathVariable Long id) {
        readingProgressService.deleteReadingProgress(id);
    }
}
