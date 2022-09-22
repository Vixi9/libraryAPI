package fr.ensicaen.ensibrary.libraryapi.entity;

import fr.ensicaen.ensibrary.libraryapi.models.State;
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


}
