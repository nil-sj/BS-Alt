package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.BookDTO;
import com.bookself.bookself_api.models.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setDescription(book.getDescription());
        dto.setIsbn(book.getIsbn());
        dto.setCoverImagePath(book.getCoverImagePath());
        return dto;
    }

    public static Book toEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setIsbn(dto.getIsbn());
        book.setCoverImagePath(dto.getCoverImagePath());
        return book;
    }
}
