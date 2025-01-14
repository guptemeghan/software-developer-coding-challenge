package com.example.auction.Service;

import com.example.auction.Repository.UserRepository;
import com.example.auction.Exception.UserNotFoundException;
import com.example.auction.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by meghan on 8/4/2019.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public Users getUserById(int id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user found for that userId"));
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }
}
