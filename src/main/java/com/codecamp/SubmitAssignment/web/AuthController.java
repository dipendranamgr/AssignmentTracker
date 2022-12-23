package com.codecamp.SubmitAssignment.web;

import com.codecamp.SubmitAssignment.domain.Users;
import com.codecamp.SubmitAssignment.dto.AuthCredentialsRequest;
import com.codecamp.SubmitAssignment.dto.AuthResponse;
import com.codecamp.SubmitAssignment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    //AuthenticationProvider authenticationManager;
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/home")
    public String getHome(){
        return "This is home";
    }
    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request){
        //System.out.println(request.getUsername());
        try {
            //.out.println(request.getUsername());
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            Users user = (Users) authenticate.getPrincipal();

            String accessToken = jwtUtil.generateToken(user);
            AuthResponse authResponse = new AuthResponse(request.getUsername(),accessToken);

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION
                            //jwtUtil.generateToken(user)
                    )
                    //.body(userViewMapper.toUserView(user));
                    //.body(user);
                    .body(authResponse);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        //return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
