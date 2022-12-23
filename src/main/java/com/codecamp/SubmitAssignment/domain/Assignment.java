package com.codecamp.SubmitAssignment.domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
public class Assignment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String status,githubUrl,branch,codeReviewVideoUrl;
    @Nullable
    @ManyToOne(optional = false) @JoinColumn(name="users_id",nullable = false,foreignKey = @ForeignKey(name="FK_USERS_ID"))
    Users assignedTo;

}
