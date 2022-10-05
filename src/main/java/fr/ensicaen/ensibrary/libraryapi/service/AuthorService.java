package fr.ensicaen.ensibrary.libraryapi.service;

import fr.ensicaen.ensibrary.libraryapi.entity.Author;
import fr.ensicaen.ensibrary.libraryapi.exception.AuthorNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.AuthorDTO;
import fr.ensicaen.ensibrary.libraryapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Collection<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author get(UUID id) throws AuthorNotFoundException {
        Optional<Author> user = authorRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new AuthorNotFoundException(id);
        }
    }

    @Transactional
    public Author add(AuthorDTO author) {
        return authorRepository.save(author.toEntity());
    }

    @Transactional
    public Author update(UUID id, AuthorDTO author) throws AuthorNotFoundException {
        Author newAuthor = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setId(author.getId());
        return authorRepository.save(newAuthor);
    }

    public void delete(UUID id) throws AuthorNotFoundException {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new AuthorNotFoundException(id);
        }
    }


}
