package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.entity.Borrowing;

import java.time.Duration;
import java.util.UUID;

public class BorrowingDTO {

    private UUID id;
    private Book book;

    private UUID uuidUser;

    private UUID uuidEmployee;

    private Duration duration;


    public UUID getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public UUID getUuidUser() {
        return uuidUser;
    }

    public UUID getUuidEmployee() {
        return uuidEmployee;
    }

    public Duration getDuration() {
        return duration;
    }

    Borrowing toEntity() {
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(this.book);
        borrowing.setDuration(this.duration);
        borrowing.setId(this.id);
        borrowing.setUuidEmployee(this.uuidEmployee);
        borrowing.setUuidUser(this.uuidUser);
        return borrowing;
    }
}
