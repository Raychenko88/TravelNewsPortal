package org.example.dao;

import org.example.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDAO extends JpaRepository<News, Integer> {

    List<News> findAllByCountry(String string);
}
