package com.eaglesoft.contact_service.controller;

import com.eaglesoft.contact_service.entity.Contact;
import com.eaglesoft.contact_service.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId) {
        return contactService.getContactsOfUser(userId);
    }
}
