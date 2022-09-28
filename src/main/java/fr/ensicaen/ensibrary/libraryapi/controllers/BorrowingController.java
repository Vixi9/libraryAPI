package fr.ensicaen.ensibrary.libraryapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/borrowings")
public class BorrowingController {
    /* Todo remplacer par le modele borrowing*/

    @GetMapping("/")
    public String getBorrowings() {
        return "Get Borrowings";
    }

    @PostMapping("/")
    public String addBorrowing() {
        return "Post Borrowing";
    }

    @GetMapping("/{id}")
    public String getBorrowing(@PathVariable String id) {
        return "Borrowing " + id;
    }

    @PostMapping("/{id}")
    public String updateBorrowing(@PathVariable String id) {
        return "Update Borrowing " + id;
    }

    @PostMapping("/{id}")
    public String deleteBorrowing(@PathVariable String id) {
        return "Delete Borrowing " + id;
    }

}
