package fr.ensicaen.ensibrary.libraryapi.controller;

import fr.ensicaen.ensibrary.libraryapi.entity.Borrowing;
import fr.ensicaen.ensibrary.libraryapi.exception.BookNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.BorrowingNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.BorrowingDTO;
import fr.ensicaen.ensibrary.libraryapi.service.BorrowingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Borrowing> getBorrowings() {
        return borrowingService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Borrowing getBorrowing(@PathVariable String id) throws BorrowingNotFoundException {
        return borrowingService.get(UUID.fromString(id));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Borrowing addBorrowing(@RequestBody BorrowingDTO borrowingDTO) throws BookNotFoundException {
        return borrowingService.add(borrowingDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Borrowing updateBorrowing(@PathVariable String id, @RequestBody BorrowingDTO borrowingDTO) throws BorrowingNotFoundException, BookNotFoundException {
        return borrowingService.update(UUID.fromString(id), borrowingDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBorrowing(@PathVariable String id) throws BorrowingNotFoundException {
        borrowingService.delete(UUID.fromString(id));
    }

}
