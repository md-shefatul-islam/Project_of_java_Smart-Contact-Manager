package com.dao;

import com.model.Contact;

import java.util.List;

public interface ContactDao {
    public List<Contact> getAll();
    public Contact get(int id);
//    public Contact get(String name);
public void create(Contact contact);
    public void update(Contact contact);
    public void delete(int id);
}
