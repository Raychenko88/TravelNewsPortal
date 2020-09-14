package org.example.dao;

import org.example.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDAO extends PagingAndSortingRepository<News, Integer> {

    Page<News> findAllByCountryAndPageLanguage(String pageLanguage, String country, Pageable pageable);

    Page<News> findAllByPageLanguage(String pageLanguage, Pageable pageable);

    Page<News> findAllByCountryIsNotAndPageLanguage(String pageLanguage, String country, Pageable pageable);
}
