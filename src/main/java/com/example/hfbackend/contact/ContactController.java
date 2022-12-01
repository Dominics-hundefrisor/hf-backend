package com.example.hfbackend.contact;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Contact add(@Valid @RequestBody Contact object) {
        return service.add(object);
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

    @PutMapping("/{id}")
    public Contact put (@PathVariable("id") Long id, @Valid @RequestBody Contact object){
        return service.update(id, object, false);
    }


    @PatchMapping("/{id}")
    public Contact patch(@PathVariable("id") Long id, @Valid @RequestBody Contact object){
        return service.update(id, object, true);
    }


    private Contact update(Long id, Contact object, boolean partial){
        return service.update(id, object, partial);
    }
}
