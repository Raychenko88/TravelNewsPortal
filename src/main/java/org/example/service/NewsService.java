package org.example.service;

import org.example.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

    News save(News news);

    News update(News news);

    News findById(Integer id);

    Page<News> findAll(Integer page, Integer size);

    Page<News> findAllByCountry(String country, Integer page, Integer size);

    void delete(News news);
}
