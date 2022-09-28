package fr.ensicaen.ensibrary.libraryapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/authors")
public class AuthorController {

    /* Todo remplacer par le modele author*/

    @GetMapping("/")
    public String getAuthors() {
        return "Get Authors";
    }

    @PostMapping("/")
    public String addAuthor() {
        return "Post Author";
    }

    @GetMapping("/{id}")
    public String getAuthor(@PathVariable String id) {
        return "Author " + id;
    }

    @PostMapping("/{id}")
    public String updateAuthor(@PathVariable String id) {
        return "Update Author " + id;
    }

    @PostMapping("/{id}")
    public String deleteAuthor(@PathVariable String id) {
        return "Delete Author " + id;
    }

}
