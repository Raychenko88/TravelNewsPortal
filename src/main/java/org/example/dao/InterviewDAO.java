package org.example.dao;

import org.example.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewDAO extends JpaRepository<Interview, Integer> {
}
