package fr.ensicaen.ensibrary.libraryapi.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;
import java.util.UUID;

@Entity
public class Borrowing {

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
    private Book book;

    private UUID uuidUser;
    private UUID uuidEmployee;

    private Duration duration;

    private Date borrowingDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public UUID getUuidUser() {
        return uuidUser;
    }

    public void setUuidUser(UUID uuidUser) {
        this.uuidUser = uuidUser;
    }

    public UUID getUuidEmployee() {
        return uuidEmployee;
    }

    public void setUuidEmployee(UUID uuidEmployee) {
        this.uuidEmployee = uuidEmployee;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}
