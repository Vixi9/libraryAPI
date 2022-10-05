package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.entity.Borrowing;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

public class BorrowingDTO {

    private UUID id;
    private UUID bookId;

    private UUID uuidUser;

    private UUID uuidEmployee;

    private Duration duration;

    private Date borrowingDate;

    public UUID getId() {
        return id;
    }

    public UUID getBookId() {
        return bookId;
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

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public Borrowing toEntity() {
        Borrowing borrowing = new Borrowing();
        borrowing.setDuration(this.duration);
        borrowing.setId(this.id);
        borrowing.setUuidEmployee(this.uuidEmployee);
        borrowing.setUuidUser(this.uuidUser);
        borrowing.setBorrowingDate(this.borrowingDate);
        return borrowing;
    }
}
