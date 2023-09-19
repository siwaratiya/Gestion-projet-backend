package com.example.yyyyyy.Services;

import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Entity.UserPrinciple;
import com.example.yyyyyy.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AuthUserServiceImp implements AuthUserService
{

    //injection des dépendences
  /*  private final UserRepository repository;
    private final RoleRepository roleRepository;
    //méthode pour encoder un password
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegistrationRequest request) {
        User user = RegistrationRequest.toEntity(request);
        // encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setRole(UserRole.APPRENANT);
        // user.getRoles().add(null)
        /////////many rols
        Set<String> strRoles = request.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName("UTILISATEUR")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName("ADMINISTRATEUR")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "appr":
                        Role modRole = roleRepository.findByName("APPRENANT")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName("VISITEUR")
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);


        User savedUser = repository.save(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", savedUser.getId()); // optional
        claims.put("fullName", savedUser.getFullname() ); // optional

        // generate a JWT token
        String token = jwtUtils.generateToken(savedUser, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                //recherche email and password in database
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final User user = repository.findByEmail(request.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        //add userid and fullname
        claims.put("userId", user.getId()); // optional
        claims.put("fullName", user.getFullname() ); // optional
        // generate a JWT token
        String token = jwtUtils.generateToken(user, claims);
        return AuthenticationResponse
                .builder()
                .token(token)
                .build();
    }

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
                );

        return UserPrinciple.build(user);
    }*/


}