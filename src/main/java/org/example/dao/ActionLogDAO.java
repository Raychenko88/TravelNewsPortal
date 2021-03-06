package org.example.dao;

import org.example.model.ActionLog;
import org.example.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogDAO extends PagingAndSortingRepository<ActionLog, Integer> {

    Page<ActionLog> findAll(Pageable pageable);
}
