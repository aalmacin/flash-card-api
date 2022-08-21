package com.raidrin.flashcard.controllers;

import com.raidrin.flashcard.resolvers.CardResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Controller
public class GraphQLController {
    @Autowired
    private CardResolver cardResolver;

    @Value("classpath:schema.graphql")
    private Resource schemaResource;

    private GraphQL graphql;

    @PostConstruct
    public void setup() throws IOException {
        // Get the file from the resource
        File schemaFile = schemaResource.getFile();

        // Pass the file to the
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);

        RuntimeWiring runtimeWiring = buildWiring();

        GraphQLSchema graphQLSchema = new SchemaGenerator()
                .makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        graphql = GraphQL.newGraphQL(graphQLSchema).build();
    }

    /**
     * API endpoint for GraphQL
     *
     * @param query query sent by the client
     * @return graphql response
     */
    @PostMapping("/graphql")
    public ResponseEntity<Object> graphql(@RequestBody String query) {
        ExecutionResult result = graphql.execute(query);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Build the wiring or resolvers
     *
     * @return Runtime Wiring instance
     */
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring ->
                        typeWiring
                                .dataFetcher("cards", cardResolver.findAllCards())
                )
                .build();
    }
}
