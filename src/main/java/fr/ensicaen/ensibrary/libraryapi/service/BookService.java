package fr.ensicaen.ensibrary.libraryapi.service;

import fr.ensicaen.ensibrary.libraryapi.entity.Book;
import fr.ensicaen.ensibrary.libraryapi.exception.AuthorNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.BookNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.exception.PublisherNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.BookDTO;
import fr.ensicaen.ensibrary.libraryapi.repository.AuthorRepository;
import fr.ensicaen.ensibrary.libraryapi.repository.BookRepository;
import fr.ensicaen.ensibrary.libraryapi.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
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
        Book newBook = book.toEntity();
        newBook.setAuthor(this.authorRepository.getReferenceById(book.getAuthorId()));
        newBook.setPublisher(this.publisherRepository.getReferenceById(book.getPublisherId()));
        return bookRepository.save(newBook);
    }

    @Transactional
    public Book update(UUID id, BookDTO book) throws BookNotFoundException, AuthorNotFoundException, PublisherNotFoundException {
        Book newBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(this.authorRepository.findById(book.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthorId())));
        newBook.setPublisher(this.publisherRepository.findById(book.getPublisherId()).orElseThrow(() -> new PublisherNotFoundException(book.getPublisherId())));
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
