package com.eaglesoft.contact_service.services;

import com.eaglesoft.contact_service.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactsOfUser(Long userId);
}