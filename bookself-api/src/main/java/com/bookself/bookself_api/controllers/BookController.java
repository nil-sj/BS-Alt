package com.bookself.bookself_api.controllers;

import com.bookself.bookself_api.dtos.BookDTO;
import com.bookself.bookself_api.mappers.BookMapper;
import com.bookself.bookself_api.models.Book;
import com.bookself.bookself_api.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.findBookById(id);
        return book.map(BookMapper::toDTO).orElse(null);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks().stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        return BookMapper.toDTO(bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
