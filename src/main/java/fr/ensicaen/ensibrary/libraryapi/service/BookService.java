package fr.ensicaen.ensibrary.libraryapi.service;

import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.exception.BookNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.BookDTO;
import fr.ensicaen.ensibrary.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Collection<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book get(UUID id) throws BookNotFoundException {
        Optional<Book> user = bookRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Transactional
    public Book add(BookDTO book) {
        return bookRepository.save(book.toEntity());
    }

    @Transactional
    public Book update(UUID id, BookDTO book) throws BookNotFoundException {
        Book newBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setPublisher(book.getPublisher());
        newBook.setDateReleased(book.getDateReleased());
        return bookRepository.save(newBook);
    }

    public void delete(UUID id) throws BookNotFoundException {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }


}
