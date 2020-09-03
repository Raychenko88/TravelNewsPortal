package org.example.service;

import org.example.model.ActionLog;

public interface ActionLogService {

    ActionLog save(ActionLog actionLog);

    ActionLog update(ActionLog actionLog);

    ActionLog findById(Integer id);

    void delete(ActionLog actionLog);
}
