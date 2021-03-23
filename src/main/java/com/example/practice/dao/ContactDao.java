package com.example.practice.dao;

import com.example.practice.dto.ContactDto;
import com.example.practice.exception.ContactNotFoundException;
import com.example.practice.model.Contact;
import com.example.practice.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDao {
    @Autowired
    ContactRepo contactRepo;


    public List<Contact> getAllContacts() {
       return  contactRepo.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepo.findById(id).orElseThrow(() -> new ContactNotFoundException());
    }

    public Contact addContact(Contact contact) {
       return contactRepo.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepo.deleteById(id);
    }

    public Contact updateContact(Long id,ContactDto contactDto) {
        Contact contact=contactRepo.findById(id).orElseThrow(ContactNotFoundException::new);
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        return contact;
    }

    public boolean existsCheck(Long phone) {
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");
              //  .withMatcher("phone");
        Contact probe=new Contact();
        probe.setPhone(phone);
        Example<Contact> example= Example.of(probe,modelMatcher);
        boolean exists = contactRepo.exists(example);
        return exists;
    }
    public boolean existsById(Long id)
    {
        boolean exists=contactRepo.existsById(id);
        return exists;
    }
}
