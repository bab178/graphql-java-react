package com.graphqljava.book.database;

import java.util.List;

import com.graphqljava.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByBookId(String id);
    public List<Book> findByLastName(String lastName);

}