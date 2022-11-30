package com.example.hfbackend.contact;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "Address")
    private String address;

    public Contact(String phoneNumber, String email, String address){
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

}
