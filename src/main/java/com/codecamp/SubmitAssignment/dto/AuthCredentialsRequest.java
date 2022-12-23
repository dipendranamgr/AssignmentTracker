package com.codecamp.SubmitAssignment.dto;

import com.sun.istack.NotNull;
import lombok.Data;
//import org.hibernate.validator.constraints.Length;

@Data
public class AuthCredentialsRequest {
    @NotNull //@Length(min=6,max=30)
    String username,password;
}
