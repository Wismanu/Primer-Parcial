package com.PrimerParcial.app.services;

import com.PrimerParcial.app.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> allUsers();
    User createUser(User user);
    User updateUser(Long id, User user);
}