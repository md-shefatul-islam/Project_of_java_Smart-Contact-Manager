package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public User getById(int id);
    public User get(String name);
    public void create(User user);
    public void update(User user);
    public void delete(int id);
}
