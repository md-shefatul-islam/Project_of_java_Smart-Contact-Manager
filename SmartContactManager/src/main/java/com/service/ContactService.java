package com.service;

import com.model.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContact(String query);
}
