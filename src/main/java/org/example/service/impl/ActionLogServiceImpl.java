package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.ActionLogDAO;
import org.example.model.ActionLog;
import org.example.service.ActionLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActionLogServiceImpl implements ActionLogService {

    private final ActionLogDAO actionLogDAO;

    @Override
    public ActionLog save(ActionLog actionLog) throws Exception {
        if (actionLog.getId() != null) {
            throw new Exception("ActionLog already exists");
        }
        return actionLogDAO.save(actionLog);
    }

    @Override
    public ActionLog update(ActionLog actionLog) throws Exception {
        if (actionLog.getId() == null) {
            throw new Exception("ActionLog id not found");
        }
        return actionLogDAO.save(actionLog);
    }

    @Override
    public ActionLog findById(Integer id) throws Exception {
        return actionLogDAO.findById(id).orElseThrow(() -> new Exception("ActionLog not found"));
    }

    @Override
    public Page<ActionLog> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return actionLogDAO.findAll(pageRequest);
    }

    @Override
    public void delete(ActionLog actionLog) {
        actionLogDAO.delete(actionLog);
    }
}
