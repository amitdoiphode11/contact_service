package com.eaglesoft.contact_service.controller;

import com.eaglesoft.contact_service.entity.Contact;
import com.eaglesoft.contact_service.services.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId) {
        log.info("getContacts " + userId);
        return contactService.getContactsOfUser(userId);
    }

    @PostMapping("/")
    public List<Contact> saveContacts(@Validated @RequestBody List<Contact> contactList) throws Exception {
        log.info("saveContact " + contactList);
        return contactService.saveContacts(contactList);
    }

    @PutMapping("/user/{userId}")
    public List<Contact> updateContacts(@PathVariable("userId") Long userId,
                                        @Validated @RequestBody List<Contact> contactList) {
        log.info("updateContacts " + contactList);
        return contactService.updateContacts(userId, contactList);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteContact(@PathVariable("userId") Long userId){
        log.info("deleteContact "+userId);
        contactService.deleteContacts(userId);
    }
}
