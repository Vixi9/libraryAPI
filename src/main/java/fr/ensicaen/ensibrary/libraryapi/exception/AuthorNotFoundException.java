package fr.ensicaen.ensibrary.libraryapi.exception;

import java.util.UUID;

public class AuthorNotFoundException extends Exception {

    private static final String AUTHOR_NOT_FOUND_MESSAGE = "Can not find author with id ";

    public AuthorNotFoundException(UUID id) {
        super(AUTHOR_NOT_FOUND_MESSAGE + id.toString());
    }
}
