package com.graphqljava.bookdetails.input;

public class BookInput {

  private Integer bookId;
  private String name;
  private Integer pageCount;
//  private String authorFirstName;
//  private String authorLastName;

  public Integer getBookId() { return bookId; }
  public void setBookId(int bookId) { this.bookId = bookId; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Integer getPageCount() { return pageCount; }
  public void setPageCount(int pageCount) { this.pageCount = pageCount; }

//  public String getAuthorFirstName() { return authorFirstName; }
//  public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }
//  public String getAuthorLastName() { return authorLastName; }
//  public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }
}
