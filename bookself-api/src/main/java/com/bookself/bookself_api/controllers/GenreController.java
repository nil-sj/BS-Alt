package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.GenreDTO;
import com.bookself.bookself_api.mappers.GenreMapper;
import com.bookself.bookself_api.models.Genre;
import com.bookself.bookself_api.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public GenreDTO getGenreById(@PathVariable Long id) {
        Optional<Genre> genre = genreService.findGenreById(id);
        return genre.map(GenreMapper::toDTO).orElse(null);
    }

    @GetMapping
    public List<GenreDTO> getAllGenres() {
        return genreService.findAllGenres().stream()
                .map(GenreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public GenreDTO createGenre(@RequestBody GenreDTO genreDTO) {
        Genre genre = GenreMapper.toEntity(genreDTO);
        return GenreMapper.toDTO(genreService.saveGenre(genre));
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
