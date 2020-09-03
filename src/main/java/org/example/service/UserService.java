package org.example.service;

import org.example.model.User;

public interface UserService {

    User save(User user);

    User update(User user);

    User findById(Integer id);

    void delete(User user);
}
