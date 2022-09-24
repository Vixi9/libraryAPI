package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Author;
import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.entity.Publisher;

import java.util.Date;
import java.util.UUID;

public class BookDTO {

    private UUID id;
    private Author author;

    private Publisher publisher;

    private State state;

    private String title;

    private Date dateReleased;


    public UUID getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
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
        book.setAuthor(this.author);
        book.setDateReleased(this.dateReleased);
        book.setId(this.id);
        book.setPublisher(this.publisher);
        book.setState(this.state);
        book.setTitle(this.title);
        return book;
    }
}
