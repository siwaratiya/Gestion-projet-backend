package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Config.JwtProvider;
import com.example.yyyyyy.Entity.Role;
import com.example.yyyyyy.Entity.RoleName;
import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Repository.RoleRepository;
import com.example.yyyyyy.Repository.UserRepository;
import com.example.yyyyyy.message.JwtResponse;
import com.example.yyyyyy.message.LoginForm;
import com.example.yyyyyy.message.SignUpForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()

                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);

        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
        User userdetails = user.get();

        if(!userdetails.getEtat()){
            return ResponseEntity.ok("Not activated");
        }

        return ResponseEntity.ok(new JwtResponse(jwt));
    }
 
    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
       if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
          switch(role) {
          case "admin":
                        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
            roles.add(adminRole);
            break;
          case "cp":
              Role cpRole = roleRepository.findByName(RoleName.ROLE_CHEF_PROJET)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(cpRole);
            break;
              case "emp":
                  Role empRole = roleRepository.findByName(RoleName.ROLE_EMPL)
                          .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
                  roles.add(empRole);
                  break;
          default:
              Role cleintRole = roleRepository.findByName(RoleName.ROLE_CLIENT)
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: Role not found."));
              roles.add(cleintRole);
          }
        });
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User Registred !");
    }
    @GetMapping(value = "/role/{username}")
    public User getRolesByUsername(@PathVariable(value = "username") String username) {
        Optional<User> user = userRepository.findByUsername(username);


        return user.orElse(new User());
    }
}
