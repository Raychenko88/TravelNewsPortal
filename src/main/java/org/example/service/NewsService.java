package org.example.service;

import org.example.model.News;

import java.util.List;

public interface NewsService {

    News save(News news);

    News update(News news);

    News findById(Integer id);

    List<News> findAll();

    List<News> findAllByCountry(String string);

    void delete(News news);
}
