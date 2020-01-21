package com.graphqltest.practice.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqltest.practice.model.DAOUser;
import com.graphqltest.practice.model.dto.UserDTO;
import com.graphqltest.practice.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOUserMutation implements GraphQLMutationResolver {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    public DAOUser createUser(final String username, final String password) {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        return this.jwtUserDetailsService.save(user);
    }
}
