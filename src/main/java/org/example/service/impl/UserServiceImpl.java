package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public User save(User user) throws Exception {
        if (user.getId() != null) {
            throw new Exception("User already exists");
        }
        return userDAO.save(user);
    }

    @Override
    public User update(User user) throws Exception {
        if (user.getId() == null) {
            throw new Exception("User id not found");
        }
        return userDAO.save(user);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userDAO.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
