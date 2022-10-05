package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Author;

import java.util.UUID;

public class AuthorDTO {

    private UUID id;
    private String firstName;

    private String lastName;

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Author toEntity() {
        Author author = new Author();
        author.setFirstName(this.firstName);
        author.setLastName(this.lastName);
        author.setId(this.id);
        return author;
    }
}
