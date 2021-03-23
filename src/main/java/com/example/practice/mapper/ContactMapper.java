package com.example.practice.mapper;

import com.example.practice.dto.ContactDto;
import com.example.practice.model.Contact;
import com.example.practice.model.Contact;
import org.springframework.stereotype.Component;

@Component

public class ContactMapper {
    public ContactDto contactToContactDto(Contact contact)
    {
        ContactDto dto=new ContactDto();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setEmail(contact.getEmail());
        dto.setPhone(contact.getPhone());
        return dto;

    }
    public Contact contactDtoToContact(ContactDto contactDto)
    {
        Contact contact=new Contact();
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        return contact;
    }
}
