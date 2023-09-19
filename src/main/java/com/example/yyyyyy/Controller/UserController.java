package com.example.yyyyyy.Controller;

import com.example.yyyyyy.Entity.Role;
import com.example.yyyyyy.Entity.User;
import com.example.yyyyyy.Repository.RoleRepository;
import com.example.yyyyyy.Repository.UserRepository;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@RestController
@RequestMapping(value = "api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id ) throws Exception{
        return userRepository.findById(id).orElseThrow(()->new Exception("!!!!!"));
    }


    @GetMapping(value = "/all")
    public List<User> getAll()  {
        return userRepository.findAll();
    }

    @DeleteMapping(value="/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
        userRepository.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }


    @PutMapping(value="/{id}")
    public ResponseEntity<User> updateStatus (@PathVariable Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
        user.setPassword(user.getPassword());
        user.setEtat(!user.getEtat());
        User updated = userRepository.save(user);
        return ResponseEntity.ok(updated);
    }
 /*   @GetMapping(value = "/role/{username}")
    public Set<Role> getRolesByUsername(@PathVariable(value = "username") String username) {
       Optional<User> user = userRepository.findByUsername(username);
        if (user == null) {
            // Gérer le cas où l'utilisateur n'est pas trouvé
            return null;
        }

        return user.get().getRoles();
    }*/

}
