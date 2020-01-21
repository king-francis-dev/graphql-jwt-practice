package com.graphqltest.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private List<Book> books;
}
