package com.eaglesoft.contact_service.services;

import com.eaglesoft.contact_service.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact saveContact(Contact contact);

    List<Contact> saveContacts(List<Contact> contactList);

    List<Contact> getContactsOfUser(Long userId);

    List<Contact> updateContacts(Long userId, List<Contact> contactList);

    Optional<List<Contact>> deleteContacts(Long userId);
}