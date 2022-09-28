package fr.ensicaen.ensibrary.libraryapi.controller;

import fr.ensicaen.ensibrary.libraryapi.entity.Publisher;
import fr.ensicaen.ensibrary.libraryapi.exception.PublisherNotFoundException;
import fr.ensicaen.ensibrary.libraryapi.model.PublisherDTO;
import fr.ensicaen.ensibrary.libraryapi.service.PublisherService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Publisher> getPublishers() {
       return publisherService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getPublisher(@PathVariable String id) throws PublisherNotFoundException {
        publisherService.get(UUID.fromString(id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Publisher updatePublisher(@PathVariable String id, @RequestBody PublisherDTO publisherDTO) throws PublisherNotFoundException {
        return publisherService.update(UUID.fromString(id), publisherDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePublisher(@PathVariable String id) throws PublisherNotFoundException {
        publisherService.delete(UUID.fromString(id));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Publisher addPublisher(@RequestBody PublisherDTO publisherDTO) {
        return publisherService.add(publisherDTO);
    }


}
