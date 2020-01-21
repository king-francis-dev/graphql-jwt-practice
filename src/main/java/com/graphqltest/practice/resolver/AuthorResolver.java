package com.graphqltest.practice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqltest.practice.model.Author;
import com.graphqltest.practice.model.Book;
import com.graphqltest.practice.service.fetchers.GraphQLDataFetchers;
import main.java.customlib.MethodCaller;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {
    MethodCaller test;
    public List<Book> books(Author author) {
        return GraphQLDataFetchers.books.stream()
                .filter(book -> book.getAuthor().getId().equals(author.getId()))
                .collect(Collectors.toList());
    }
}
