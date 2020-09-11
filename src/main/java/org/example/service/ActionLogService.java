package org.example.service;

import org.example.model.ActionLog;
import org.springframework.data.domain.Page;

public interface ActionLogService {

    ActionLog save(ActionLog actionLog);

    ActionLog update(ActionLog actionLog);

    ActionLog findById(Integer id);

    Page<ActionLog> findAll(Integer page, Integer size);

    void delete(ActionLog actionLog);
}
