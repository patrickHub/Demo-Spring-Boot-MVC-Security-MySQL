package com.patrichhub.boot.demo.service;

import com.patrichhub.boot.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Patrick-PC on 12.06.2018.
 */


public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
