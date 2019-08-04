package com.example.auction.Service;

import com.example.auction.Model.Users;

/**
 * Created by megha on 8/4/2019.
 */
public interface IUserService {
    Users createUser(Users user);

    Users getUserById(int id) throws Exception;
}
