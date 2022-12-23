package com.codecamp.SubmitAssignment.web;

import com.codecamp.SubmitAssignment.domain.Assignment;
import com.codecamp.SubmitAssignment.domain.Users;
import com.codecamp.SubmitAssignment.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("api/assignments")
@CrossOrigin("http://localhost:3000/")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal Users user){
    //public ResponseEntity<?> createAssignment(){
        System.out.println(user.getId());
       Assignment assignment =  assignmentService.save(user);
       // Assignment assignment =
               // assignmentService.save(user);
       return ResponseEntity.ok(assignment);
        //return ResponseEntity.ok("ok");
       // System.out.println("post mapping");
    }
    
    @GetMapping("/api/assignments/{id}")
    public ResponseEntity<?> getAssignments(@PathVariable Long id){
        Optional<Assignment> assignment =  assignmentService.getAssignments(id);
        return ResponseEntity.ok(assignment);
    }
}
