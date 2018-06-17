package com.patrichhub.boot.demo.service;

import com.patrichhub.boot.demo.model.Role;
import com.patrichhub.boot.demo.model.User;
import com.patrichhub.boot.demo.repository.RoleRepository;
import com.patrichhub.boot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Patrick-PC on 12.06.2018.
 */

@Service("userService")
public class UserServiceImpl  implements UserService{

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;
    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new LinkedList<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
