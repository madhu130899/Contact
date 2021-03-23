package com.example.practice.service;

import com.example.practice.dao.ContactDao;
import com.example.practice.dto.ContactDto;
import com.example.practice.exception.ContactNotFoundException;
import com.example.practice.exception.EmptyFieldException;
import com.example.practice.exception.PhoneAlreadyExistsException;
import com.example.practice.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    ContactDao contactDao;

    @Autowired
    ContactMapper contactMapper;

    public List<ContactDto> getAllContacts() {
         return  contactDao.getAllContacts().stream().map(contact -> contactMapper.contactToContactDto(contact)).collect(Collectors.toList());
    }

    public ContactDto getContactById(Long id) {
        return contactMapper.contactToContactDto(contactDao.getContactById(id));
    }

    public ContactDto addContact(ContactDto contactDto) {
        if (contactDto.getName().equals("")) {
            //  String name = null;
            throw new EmptyFieldException();
        }
        else if (contactDto.getEmail().equals("")) {
            throw new EmptyFieldException();
        }
        else if (contactDto.getPhone().equals("")) {
            throw new EmptyFieldException();
        }
        else if (contactDao.existsCheck(contactDto.getPhone())) {
            throw new PhoneAlreadyExistsException();
        }
        else {
            return contactMapper.contactToContactDto(contactDao.addContact(contactMapper.contactDtoToContact(contactDto)));
        }
    }

    public void deleteContact(Long id) {
          contactDao.deleteContact(id);
    }

    public ContactDto updateContact(Long id,ContactDto contactDto) {
        if (!contactDao.existsById(id)) {
            throw new ContactNotFoundException();
        } else if (contactDto.getName().equals("")) {
            //  String name = null;
            throw new EmptyFieldException();
        } else if (contactDto.getEmail().equals("")) {
            throw new EmptyFieldException();
        } else if (contactDto.getPhone().equals("")) {
            throw new EmptyFieldException();
        } else if (contactDao.existsCheck(contactDto.getPhone())) {
            throw new PhoneAlreadyExistsException();
        } else {
            return contactMapper.contactToContactDto(contactDao.updateContact(id, contactDto));
        }
    }
}
