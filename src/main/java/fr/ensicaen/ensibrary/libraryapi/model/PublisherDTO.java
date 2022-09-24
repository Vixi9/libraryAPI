package fr.ensicaen.ensibrary.libraryapi.model;

import fr.ensicaen.ensibrary.libraryapi.entity.Publisher;

import java.util.UUID;

public class PublisherDTO {

    private UUID id;
    private String name;


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Publisher toEntity() {
        Publisher publisher = new Publisher();
        publisher.setId(this.id);
        publisher.setName(this.name);
        return publisher;
    }
}
