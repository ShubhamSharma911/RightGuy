package com.rightguy.services.user;

import com.rightguy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
}
