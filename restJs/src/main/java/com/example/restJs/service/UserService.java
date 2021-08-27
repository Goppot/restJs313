package com.example.restJs.service;

import com.example.restJs.model.Role;
import com.example.restJs.model.User;

public interface UserService {

    public User addUser(User user);

    public Iterable<User> getAll();

    public User getByUSerId(int id);

    User getShowId();

    public void deleteUser(User user);
}
