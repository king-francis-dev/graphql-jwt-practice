package com.graphqltest.practice.service;

import com.graphqltest.practice.dao.UserDao;
import com.graphqltest.practice.model.DAOUser;
import com.graphqltest.practice.model.dto.UserDTO;
import com.graphqltest.practice.service.implementation.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DAOUser daoUser = userDao.findByUsername(username);
        System.out.println("test");
        if (daoUser != null) {
            return new UserDetailsImp(daoUser.getUsername(), daoUser.getPassword());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }
}
