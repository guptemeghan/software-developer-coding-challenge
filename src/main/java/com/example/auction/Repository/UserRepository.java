package com.example.auction.Repository;

import com.example.auction.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by meghan on 8/4/2019.
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

}
