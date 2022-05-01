package com.graphqljava.book;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphqljava.book.database.BookRepository;
import com.graphqljava.book.model.Book;

public class GraphQLMutation implements GraphQLRootResolver {
    private final BookRepository bookRepository;

    public GraphQLMutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String name, int pageCount) {
        Book newBook = new Book(name, pageCount);
        bookRepository.insert(newBook);
        return newBook;
    }
}