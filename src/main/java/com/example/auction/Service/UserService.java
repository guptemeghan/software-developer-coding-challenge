package com.example.auction.Service;

import com.example.auction.Dao.UserRepository;
import com.example.auction.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;

/**
 * Created by meghan on 8/4/2019.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public Users getUserById(int id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException());
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }
}
