package fr.ensicaen.ensibrary.libraryapi.exception;

import java.util.UUID;

public class BorrowingNotFoundException extends Exception {

    private static final String BORROWING_NOT_FOUND_MESSAGE = "Can not find borrowing with id ";

    public BorrowingNotFoundException(UUID id) {
        super(BORROWING_NOT_FOUND_MESSAGE + id.toString());
    }
}
