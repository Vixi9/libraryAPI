package fr.ensicaen.ensibrary.libraryapi.controller;

import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.exception.AuthorNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.BookNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.PublisherNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.BookDTO;
import fr.ensicaen.ensibrary.libraryapi.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController("/books")
public class BookController {

    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/")
    public Collection<Book> getBooks() {
        return bookService.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody BookDTO bookDTO) {
        return bookService.add(bookDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable String id) throws BookNotFoundException {
        return bookService.get(UUID.fromString(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@PathVariable String id, @RequestBody BookDTO bookDTO) throws BookNotFoundException, AuthorNotFoundException, PublisherNotFoundException {
        return bookService.update(UUID.fromString(id), bookDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable String id) throws BookNotFoundException {
        bookService.delete(UUID.fromString(id));
    }


}