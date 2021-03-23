package com.example.practice.model;


import javax.persistence.*;

@Entity
@Table(name="Contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "phno")
    Long phone;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

}