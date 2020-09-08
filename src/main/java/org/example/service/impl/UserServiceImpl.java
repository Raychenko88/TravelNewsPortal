package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<User> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return userDAO.findAll(pageRequest);
    }

    @Override
    public User findByLogin(String login) throws Exception {
        if (userDAO.findByLogin(login) == null) {
            throw new Exception("user with this login was not found");
        }
        return userDAO.findByLogin(login);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
