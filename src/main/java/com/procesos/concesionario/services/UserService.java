package com.procesos.concesionario.services;

import com.procesos.concesionario.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> allUsers();
    User createUser(User user);
    User updateUser(Long id, User user);
}
