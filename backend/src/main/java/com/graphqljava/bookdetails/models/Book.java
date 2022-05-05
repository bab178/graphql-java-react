package com.graphqljava.bookdetails.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "book")
public class Book {

  private Integer id;
  private String name;
  private Integer pageCount;
  private Author author;


  @DynamoDBHashKey(attributeName = "id")
  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }

  @DynamoDBAttribute(attributeName="name")
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  @DynamoDBAttribute(attributeName="pageCount")
  public Integer getPageCount() { return pageCount; }
  public void setPageCount(Integer pageCount) { this.pageCount = pageCount; }

  @DynamoDBAttribute(attributeName="author")
  public Author getAuthor() { return author; }
  public void setAuthor(Author author) { this.author = author; }

}
