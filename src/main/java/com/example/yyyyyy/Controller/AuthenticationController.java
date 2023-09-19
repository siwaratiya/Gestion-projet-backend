package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Dto.AuthenticationRequest;
import com.example.yyyyyy.Dto.AuthenticationResponse;
import com.example.yyyyyy.Dto.RegistrationRequest;
import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Repository.UserRepository;
import com.example.yyyyyy.Services.AuthUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  /*  private final AuthUserService service;
    private  final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegistrationRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/listerUser")
    public List<User> getUsers(){
        return userRepository.findAll();
    }*/}