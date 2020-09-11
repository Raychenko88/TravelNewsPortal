package org.example.dao;

import org.example.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDAO extends PagingAndSortingRepository<News, Integer> {

    Page<News> findAllByCountry(String country, Pageable pageable);

    Page<News> findAll(Pageable pageable);

    Page<News> findAllByCountryIsNot(String country, Pageable pageable);
}
