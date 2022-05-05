package com.graphqljava.bookdetails.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqljava.bookdetails.models.Book;

import java.util.List;
import java.util.stream.Collectors;

public class QueryResolver implements GraphQLQueryResolver {

  public Book getBookById(int id) {
    return getDB().load(Book.class, id);
  }

  public List<Book> getBookList() {
    return getDB().scan(Book.class, new DynamoDBScanExpression()).stream().collect(Collectors.toList());
  }


  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.US_EAST_2);

    return new DynamoDBMapper(builder.build());
  }

}