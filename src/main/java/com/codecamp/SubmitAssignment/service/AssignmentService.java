package com.codecamp.SubmitAssignment.service;


import com.codecamp.SubmitAssignment.domain.Assignment;
import com.codecamp.SubmitAssignment.domain.Users;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AssignmentService {
    public Assignment save(Users user);

    Optional<Assignment> getAssignments(Long id);
}
