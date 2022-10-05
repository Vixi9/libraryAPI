package fr.ensicaen.ensibrary.libraryapi.controller;

import fr.ensicaen.ensibrary.libraryapi.entity.Author;
import fr.ensicaen.ensibrary.libraryapi.exception.AuthorNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.AuthorDTO;
import fr.ensicaen.ensibrary.libraryapi.service.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "authors")
public class AuthorController {

    private final AuthorService authorService;

    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/")
    public Collection<Author> getAuthors() {
        return authorService.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.add(authorDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable String id) throws AuthorNotFoundException {
        return authorService.get(UUID.fromString(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author updateAuthor(@PathVariable String id, @RequestBody AuthorDTO authorDTO) throws AuthorNotFoundException {
        return authorService.update(UUID.fromString(id), authorDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor(@PathVariable String id) throws AuthorNotFoundException {
        authorService.delete(UUID.fromString(id));
    }

}
