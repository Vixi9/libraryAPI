package fr.ensicaen.ensibrary.libraryapi.exception;

import java.util.UUID;

public class PublisherNotFoundException extends Exception {

    private static final String PUBLISHER_NOT_FOUND_MESSAGE = "Can not find publisher with id ";

    public PublisherNotFoundException(UUID id) {
        super(PUBLISHER_NOT_FOUND_MESSAGE + id.toString());
    }
}
