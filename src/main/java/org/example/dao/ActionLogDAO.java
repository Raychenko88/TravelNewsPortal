package org.example.dao;

import org.example.model.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionLogDAO extends JpaRepository<ActionLog, Integer> {
}
