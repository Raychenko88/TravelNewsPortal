package org.example.dao;

import org.example.model.News;
import org.example.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingDAO extends PagingAndSortingRepository<Training, Integer> {

    Page<Training> findAll(Pageable pageable);
}
