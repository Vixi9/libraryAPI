package fr.ensicaen.ensibrary.libraryapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/publishers")
public class PublisherController {
    /* Todo remplacer par le modele publisher*/

    @GetMapping("/")
    public String getPublishers() {
        return "Get Publishers";
    }

    @PostMapping("/")
    public String addPublisher() {
        return "Post Publisher";
    }

    @GetMapping("/{id}")
    public String getPublisher(@PathVariable String id) {
        return "Publisher " + id;
    }

    @PostMapping("/{id}")
    public String updatePublisher(@PathVariable String id) {
        return "Update Publisher " + id;
    }

    @PostMapping("/{id}")
    public String deletePublisher(@PathVariable String id) {
        return "Delete Publisher " + id;
    }

}
