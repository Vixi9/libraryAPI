package fr.ensicaen.ensibrary.libraryapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/books")
public class BookController {
    /* Todo remplacer par le modele book*/

    @GetMapping("/")
    public String getBooks() {
        return "Get Books";
    }

    @PostMapping("/")
    public String addBook() {
        return "Post Book";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id) {
        return "Book " + id;
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable String id) {
        return "Update Book " + id;
    }

    @PostMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return "Delete Book " + id;
    }

}