package com.graphqljava.bookdetails.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.graphqljava.bookdetails.resolvers.MutationResolver;
import com.graphqljava.bookdetails.resolvers.QueryResolver;
import com.sun.media.jfxmedia.logging.Logger;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

public class Handler implements RequestHandler<InputType, String> {

  private GraphQLSchema schema;
  @Override
  public String handleRequest(InputType input, Context context) {
    init();

    Logger.logMsg(Logger.INFO, input.toString());

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

