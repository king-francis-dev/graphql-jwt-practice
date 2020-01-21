package com.graphqltest.practice.dao;

import com.graphqltest.practice.model.DAOUser;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}
