package org.example.service;

import org.example.model.ActionLog;
import org.springframework.data.domain.Page;

public interface ActionLogService {

    ActionLog save(ActionLog actionLog) throws Exception;

    ActionLog update(ActionLog actionLog) throws Exception;

    ActionLog findById(Integer id) throws Exception;

    Page<ActionLog> findAll(Integer page, Integer size);

    void delete(ActionLog actionLog);
}
