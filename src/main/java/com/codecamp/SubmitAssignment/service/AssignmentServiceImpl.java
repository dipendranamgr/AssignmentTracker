package com.codecamp.SubmitAssignment.service;

import com.codecamp.SubmitAssignment.domain.Assignment;
import com.codecamp.SubmitAssignment.domain.Users;
import com.codecamp.SubmitAssignment.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentServiceImpl implements AssignmentService{

    @Autowired
    AssignmentRepository assignmentRepository;

    @Override
    public Assignment save(Users user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("submit");
        System.out.println("user is "+ user.getId());
        System.out.println("Running up to here assignment service");
        assignment.setAssignedTo(user);
        assignment.setBranch("test branch");
        assignment.setGithubUrl("test url");
        assignment.setCodeReviewVideoUrl("test review");
        return assignmentRepository.save(assignment);
    }

    @Override
    public Optional<Assignment> getAssignments(Long id) {
        return assignmentRepository.findById(id);
    }
}
