package fr.ensicaen.ensibrary.libraryapi.exception;

import java.util.UUID;

public class BookNotFoundException extends Exception {

    private static final String BOOK_NOT_FOUND_MESSAGE = "Can not find book with id ";

    public BookNotFoundException(UUID id) {
        super(BOOK_NOT_FOUND_MESSAGE + id.toString());
    }
}
