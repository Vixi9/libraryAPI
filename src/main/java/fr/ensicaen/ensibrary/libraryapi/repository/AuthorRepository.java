package fr.ensicaen.ensibrary.libraryapi.repository;


import fr.ensicaen.ensibrary.libraryapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
