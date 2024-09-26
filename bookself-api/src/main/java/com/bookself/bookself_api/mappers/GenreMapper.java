package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.GenreDTO;
import com.bookself.bookself_api.models.Genre;

public class GenreMapper {

    public static GenreDTO toDTO(Genre genre) {
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        dto.setDefinition(genre.getDefinition());
        dto.setCategory(genre.getCategory().name());
        return dto;
    }

    public static Genre toEntity(GenreDTO dto) {
        Genre genre = new Genre();
        genre.setId(dto.getId());
        genre.setName(dto.getName());
        genre.setDefinition(dto.getDefinition());
        // Category should be mapped separately
        return genre;
    }
}
