package com.graphqljava.bookdetails.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.graphqljava.bookdetails.resolvers.MutationResolver;
import com.graphqljava.bookdetails.resolvers.QueryResolver;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

public class Handler {

  private GraphQLSchema schema;


  public String handleRequest(InputType input, Context context) {
    init();

    ExecutionInput exec = ExecutionInput.newExecutionInput()
      .query(input.getQuery())
      .variables(input.getVariables())
      .build();

    ExecutionResult result = GraphQL.newGraphQL(schema).build().execute(exec);

    return result.toSpecification().toString();
  }


  private void init() {
    SchemaParserBuilder parser = SchemaParser.newParser().file("schema.graphqls");
    parser.resolvers(new QueryResolver(), new MutationResolver());

    schema = parser.build().makeExecutableSchema();
  }

}

