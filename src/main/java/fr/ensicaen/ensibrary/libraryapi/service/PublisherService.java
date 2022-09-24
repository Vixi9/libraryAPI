package fr.ensicaen.ensibrary.libraryapi.service;

import fr.ensicaen.ensibrary.libraryapi.entity.Publisher;
import fr.ensicaen.ensibrary.libraryapi.exception.PublisherNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.PublisherDTO;
import fr.ensicaen.ensibrary.libraryapi.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;


    PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void delete(UUID id) throws PublisherNotFoundException {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
        } else {
            throw new PublisherNotFoundException(id);
        }
    }

    public Publisher get(UUID id) throws PublisherNotFoundException {
        return publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
    }


    @Transactional
    public Publisher update(UUID id, PublisherDTO publisher) throws PublisherNotFoundException {
        Publisher newPublisher = publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
        newPublisher.setName(publisher.getName());
        newPublisher.setId(publisher.getId());
        return publisherRepository.save(newPublisher);
    }


    @Transactional
    public Publisher add(PublisherDTO publisher) {
        return publisherRepository.save(publisher.toEntity());
    }


}
