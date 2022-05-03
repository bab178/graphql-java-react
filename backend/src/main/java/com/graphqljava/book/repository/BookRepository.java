package com.graphqljava.book.repository;

import java.util.List;

import com.graphqljava.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{ 'name' : ?0 }")
    public List<Book> findByName(String name);

    @Query("{ 'pageCount' : ?0 }")
    public List<Book> findByPageCount(int pageCount);

}