package com.eaglesoft.contact_service.services;

import com.eaglesoft.contact_service.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //Fake list of contact
    List<Contact> contactList = List.of(
            new Contact(1L, "amit1@gmail.com", "Amit1", 1L),
            new Contact(2L, "amit2@gmail.com", "Amit2", 1L),
            new Contact(3L, "aarya1@gmail.com", "Aarya1", 2L),
            new Contact(4L, "aarya2@gmail.com", "Aarya2", 2L),
            new Contact(5L, "Pooja@gmail.com", "Amit", 3L));

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        return contactList.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
