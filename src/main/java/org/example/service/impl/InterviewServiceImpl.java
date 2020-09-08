package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.InterviewDAO;
import org.example.model.Interview;
import org.example.service.InterviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewDAO interviewDAO;

    @Override
    public Interview save(Interview interview) throws Exception {
        if (interview.getId() != null) {
            throw new Exception("Interview already exists");
        }
        return interviewDAO.save(interview);
    }

    @Override
    public Interview update(Interview interview) throws Exception {
        if (interview.getId() == null) {
            throw new Exception("Interview id not found");
        }
        return interviewDAO.save(interview);
    }

    @Override
    public Interview findById(Integer id) throws Exception {
        return interviewDAO.findById(id).orElseThrow(() -> new Exception("Interview not found"));
    }

    @Override
    public Page<Interview> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return interviewDAO.findAll(pageRequest);
    }

    @Override
    public void delete(Interview interview) {
        interviewDAO.delete(interview);
    }
}
