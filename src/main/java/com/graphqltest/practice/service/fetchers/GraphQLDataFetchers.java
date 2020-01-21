package com.graphqltest.practice.service.fetchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.graphqltest.practice.model.Author;
import com.graphqltest.practice.model.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {

    public static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling", null),
            new Author("author-2", "Herman", "Melville", null),
            new Author("author-3", "Anne", "Rice", null)
    );

    public static List<Book> books = Arrays.asList(
          new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, GraphQLDataFetchers.authors.get(0)),
          new Book("book-2", "Book 2", 635, GraphQLDataFetchers.authors.get(1)),
          new Book("book-3", "Book 3", 635, GraphQLDataFetchers.authors.get(2)),
          new Book("book-4", "Harry Potter and the Chamber of Secrets", 371, GraphQLDataFetchers.authors.get(0))
    );


    public DataFetcher<Object> getBookByParamDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, Object> params = dataFetchingEnvironment.getArguments();
            String arg = params.keySet().toArray()[0].toString();
            String field = params.get(arg).toString();

            return books
                    .stream()
                    .filter(book -> new ObjectMapper().convertValue(book, HashMap.class).get(arg).equals(field))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<List<Book>> getBooks() {
            return dataFetchingEnvironment -> books;
        }

    public DataFetcher<Object> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return book.getAuthor();
        };
    }

    public DataFetcher<Object> getAuthors() {
        return dataFetchingEnvironment -> authors;
    }

    public DataFetcher<Object> getBooksByAuthor() {
        return dataFetchingEnvironment -> {
            Author author = dataFetchingEnvironment.getSource();
            return books
                    .stream()
                    .filter(book ->book.getAuthor().equals(author.getId()))
                    .collect(Collectors.toList());
        };
    }
}
