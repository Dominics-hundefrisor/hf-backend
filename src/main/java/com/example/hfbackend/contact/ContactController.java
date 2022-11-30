package com.example.hfbackend.contact;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService service;

    @GetMapping
    public List<Contact> findAll() {
        List<Contact> objects = service.findAll();
        return objects;
    }

    @PostMapping
    public Contact add(@Valid @RequestBody Contact contact) {
        return service.add(contact);
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public Contact delete(@PathVariable("id") Long id) {
        Contact result = service.findById(id);
        service.delete(id);
        return result;
    }
}
