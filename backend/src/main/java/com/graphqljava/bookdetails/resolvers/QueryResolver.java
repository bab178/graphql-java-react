package com.graphqljava.bookdetails.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.bookdetails.models.Customer;

public class QueryResolver implements GraphQLQueryResolver {


  public Customer getCustomer(int id) {
    return getDB().load(Customer.class, id);
  }

  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.US_EAST_2);

    return new DynamoDBMapper(builder.build());
  }

}