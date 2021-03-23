package com.example.practice.repository;


import com.example.practice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepo extends JpaRepository<Contact,Long> {
}
