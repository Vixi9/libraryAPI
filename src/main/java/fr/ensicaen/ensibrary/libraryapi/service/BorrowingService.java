package fr.ensicaen.ensibrary.libraryapi.service;


import fr.ensicaen.ensibrary.libraryapi.entity.Borrowing;
import fr.ensicaen.ensibrary.libraryapi.exception.BookNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.BorrowingNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.BorrowingDTO;
import fr.ensicaen.ensibrary.libraryapi.repository.BookRepository;
import fr.ensicaen.ensibrary.libraryapi.repository.BorrowingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
public class BorrowingService {


    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;


    BorrowingService(BorrowingRepository borrowingRepository, BookRepository bookRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
    }


    public void delete(UUID id) throws BorrowingNotFoundException {
        if (borrowingRepository.existsById(id)) {
            borrowingRepository.deleteById(id);
        } else {
            throw new BorrowingNotFoundException(id);
        }
    }


    public Borrowing get(UUID id) throws BorrowingNotFoundException {
        return borrowingRepository.findById(id).orElseThrow(() -> new BorrowingNotFoundException(id));
    }


    @Transactional
    public Borrowing update(UUID id, BorrowingDTO borrowing) throws BorrowingNotFoundException, BookNotFoundException {
        Borrowing newBorrowing = borrowingRepository.findById(id).orElseThrow(() -> new BorrowingNotFoundException(id));
        newBorrowing.setBook(bookRepository.findById(borrowing.getBookId()).orElseThrow(() -> new BookNotFoundException(borrowing.getBookId())));
        newBorrowing.setDuration(borrowing.getDuration());
        newBorrowing.setId(borrowing.getId());
        newBorrowing.setBorrowingDate(borrowing.getBorrowingDate());
        newBorrowing.setUuidEmployee(borrowing.getUuidEmployee());
        newBorrowing.setUuidUser(borrowing.getUuidUser());
        return borrowingRepository.save(newBorrowing);
    }


    @Transactional
    public Borrowing add(BorrowingDTO borrowing) throws BookNotFoundException {
        Borrowing newBorrowing = borrowing.toEntity();
        newBorrowing.setBook(bookRepository.findById(borrowing.getBookId()).orElseThrow(() -> new BookNotFoundException(borrowing.getBookId())));
        return borrowingRepository.save(borrowing.toEntity());
    }


    public Collection<Borrowing> getAll() {
        return borrowingRepository.findAll();
    }

}
