package org.example.service;

import org.example.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

    News save(News news) throws Exception;

    News update(News news) throws Exception;

    News findById(Integer id) throws Exception;

    Page<News> findAll(Integer page, Integer size);

    Page<News> findAllByCountry(String country, Pageable pageable);

    void delete(News news);
}
