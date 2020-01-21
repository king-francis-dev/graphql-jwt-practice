package com.graphqltest.practice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqltest.practice.dao.UserDao;
import com.graphqltest.practice.model.Author;
import com.graphqltest.practice.model.Book;
import com.graphqltest.practice.model.DAOUser;
import com.graphqltest.practice.service.fetchers.GraphQLDataFetchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserDao userDao;

    public List<Book> books() {
        return GraphQLDataFetchers.books;
    }

    public List<Author> authors() {
        return GraphQLDataFetchers.authors;
    }

    public Book bookById(String id) {
        return GraphQLDataFetchers.books
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<DAOUser> users() {
        List<DAOUser> list = new ArrayList<>();
        userDao.findAll().forEach(list::add);
        return list;
    }

}