package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Author;
import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.entity.Publisher;

import java.util.Date;
import java.util.UUID;

public class BookDTO {



    private UUID id;

    private UUID authorId;

    private UUID publisherId;

    private State state;

    private String title;

    private Date dateReleased;


    public UUID getId() {
        return id;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public UUID getPublisherId() {
        return publisherId;
    }

    public State getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public Book toEntity() {
        Book book = new Book();
        book.setDateReleased(this.dateReleased);
        book.setId(this.id);
        book.setState(this.state);
        book.setTitle(this.title);
        return book;
    }
}
