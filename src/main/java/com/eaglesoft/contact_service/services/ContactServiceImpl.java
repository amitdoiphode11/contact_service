package com.eaglesoft.contact_service.services;

import com.eaglesoft.contact_service.entity.Contact;
import com.eaglesoft.contact_service.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> saveContacts(List<Contact> contactList) {
        log.info("saveContacts " + contactList);
        return contactRepository.saveAll(contactList);
    }

    @Override
    public List<Contact> getContactsOfUser(Long userId) {
        log.info("getContactsOfUser " + userId);
        return contactRepository.findAllByUserId(userId);
    }

    @Override
    public List<Contact> updateContacts(Long userId, List<Contact> contactList) {
        log.info("updateContacts " + userId + " " + contactList);
        return contactRepository.saveAll(contactList);
    }

    @Override
    public Optional<List<Contact>> deleteContacts(Long userId) {
        log.info("deleteContacts " + userId);
        contactRepository.deleteAllByUserId(userId);
        return Optional.ofNullable(contactRepository.findAllByUserId(userId));
    }
}
