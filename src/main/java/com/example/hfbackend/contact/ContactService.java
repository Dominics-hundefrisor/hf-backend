package com.example.hfbackend.contact;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact %d not found".formatted(id)));
    }

    public Contact add(Contact contact){
        return repository.save(contact);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
