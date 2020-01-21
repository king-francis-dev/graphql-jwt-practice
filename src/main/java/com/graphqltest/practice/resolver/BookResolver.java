package com.graphqltest.practice.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqltest.practice.model.Book;
import com.graphqltest.practice.service.fetchers.GraphQLDataFetchers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookResolver implements GraphQLResolver<Book> {

}
