package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public User save(User user) {
        if (user.getId() != null || !userDAO.findByLogin(user.getLogin()).isEmpty()) {
            try {
                throw new Exception("User already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            try {
                throw new Exception("User id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userDAO.save(user);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user =  ofNullable(userDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return user.get();
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
    public User findByLogin(String login) {
       Optional<User> user =  ofNullable(userDAO.findByLogin(login)
                .stream()
                .findFirst())
                .orElseThrow(() -> new RuntimeException());
       return user.get();
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
