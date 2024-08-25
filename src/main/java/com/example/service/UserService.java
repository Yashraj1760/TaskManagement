package com.example.service;

import com.example.entities.Users;
import com.example.exception.UserException;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userDao ;

    public Users createUser(Users users){
        Users u1 = userDao.save(users);
        return u1;
    }
    public Users loginUser(Users users) throws UserException {
        String username = users.getUsername();
        Optional<Users> opt = userDao.findUsersByUsername(username);
        if (opt.isPresent()){
            return opt.get();
        }else{
            throw new UserException("user does not exist.");
        }
    }
}
