package org.example.service;

import org.example.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User save(User user);

    User update(User user);

    User findById(Integer id);

    Page<User> findAll(Integer page, Integer size);

    User findByLogin(String login);

    void delete(User user);
}
