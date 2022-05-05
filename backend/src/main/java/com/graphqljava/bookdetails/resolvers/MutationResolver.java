package com.graphqljava.bookdetails.resolvers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqljava.bookdetails.input.BookInput;
import com.graphqljava.bookdetails.models.Book;

public class MutationResolver implements GraphQLMutationResolver {

  public Book addBook(BookInput newBook) {
    Book b = getDB().load(Book.class, newBook.getBookId());

//    Author a = new Author();
//
//    a.setFirstName(newBook.getAuthorFirstName());
//    a.setLastName(newBook.getAuthorLastName());
//
//    b.setAuthor(a);

    getDB().save(b);

    return b;
  }

  private DynamoDBMapper getDB() {
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    builder.withRegion(Regions.US_EAST_2);

    return new DynamoDBMapper(builder.build());
  }

}