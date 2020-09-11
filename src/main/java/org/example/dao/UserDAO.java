package org.example.dao;

import org.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

    Page<User> findAll(Pageable pageable);

    List<User> findByLogin(String login);
}
