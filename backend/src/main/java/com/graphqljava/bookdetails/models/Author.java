package com.graphqljava.bookdetails.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBDocument
public class Author {

  private String firstName;
  private String lastName;

  @DynamoDBHashKey(attributeName = "firstName")
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }

  @DynamoDBHashKey(attributeName = "lastName")
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
}
