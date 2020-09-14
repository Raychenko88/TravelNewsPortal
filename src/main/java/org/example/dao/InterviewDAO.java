package org.example.dao;

import org.example.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewDAO extends PagingAndSortingRepository<Interview, Integer> {

    Page<Interview> findAllByPageLanguage(String pageLanguage, Pageable pageable);
}
