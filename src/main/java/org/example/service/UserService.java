package org.example.service;

import org.example.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User save(User user) throws Exception;

    User update(User user) throws Exception;

    User findById(Integer id) throws Exception;

    Page<User> findAll(Integer page, Integer size);

    User findByLogin(String login) throws Exception;

    void delete(User user);
}
