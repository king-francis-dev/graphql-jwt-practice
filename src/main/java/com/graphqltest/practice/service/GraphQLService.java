package com.graphqltest.practice.service;

import com.graphqltest.practice.service.fetchers.GraphQLDataFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class GraphQLService {

//    private GraphQL graphQL;
//
//    @Autowired
//    GraphQLDataFetchers graphQLDataFetchers;
//
//    @Value("classpath:schema.graphqls")
//    Resource resource;
//
//    @Bean
//    public GraphQL graphQL() {
//        return graphQL;
//    }
//
//    @PostConstruct
//    public void init() throws IOException {
//        File sdl = resource.getFile();
//
//        GraphQLSchema schema = buildSchema(sdl);
//        graphQL = GraphQL.newGraphQL(schema).build();
//    }
//
//    private GraphQLSchema buildSchema(File sdl) {
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
//        RuntimeWiring runtimeWiring = buildWiring();
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
//    }
//
//    private RuntimeWiring buildWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type(newTypeWiring("Query")
//                        .dataFetcher("bookById", graphQLDataFetchers.getBookByParamDataFetcher())
//                        .dataFetcher("books", graphQLDataFetchers.getBooks())
//                        .dataFetcher("authors", graphQLDataFetchers.getAuthors()))
//                .type(newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
//                .type(newTypeWiring("Author")
//                        .dataFetcher("books", graphQLDataFetchers.getBooksByAuthor()))
//                .build();
//    }
}
