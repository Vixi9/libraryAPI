package fr.ensicaen.ensibrary.libraryapi.entity;

import fr.ensicaen.ensibrary.libraryapi.model.State;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false, length = 36)
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @OneToOne
    private Author author;

    @OneToOne
    private Publisher publisher;

    private State state = State.UNAVAILABLE;

    private String title;

    private Date dateReleased;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }
}
