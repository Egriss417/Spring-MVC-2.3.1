package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(Long id);
    void updateUser(User user);
    User getUser(Long id);
    List<User> getUsers();
}
