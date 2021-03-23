package com.example.practice.controller;

import com.example.practice.dto.ContactDto;
import com.example.practice.service.ContactService;
import com.example.practice.dto.ContactDto;
import com.example.practice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;


    @GetMapping(value="api/v1/contacts")
    public List<ContactDto> getAllContacts()
    {
        return contactService.getAllContacts();
    }
    @GetMapping(value="api/v1/contacts/{id}")
    public ContactDto getContactById(@PathVariable (value = "id")Long id)
    {
        return contactService.getContactById(id);
    }
    @PostMapping(value="api/v1/contacts")
    public void addContact(@RequestBody ContactDto contactDto)
    {
         contactService.addContact(contactDto);
    }
    @DeleteMapping(value="api/v1/contacts/{id}")
    public void deleteContact(@PathVariable(value = "id")Long id)
    {
        contactService.deleteContact(id);
    }
    @PutMapping(value="api/v1/contacts/{id}")
    public ContactDto updateContact(@PathVariable(value="id")Long id,@RequestBody ContactDto contactDto)
    {
        return contactService.updateContact(id,contactDto);
    }

}
