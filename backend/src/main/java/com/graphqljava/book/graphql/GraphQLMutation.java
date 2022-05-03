package com.graphqljava.book.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.graphqljava.book.repository.BookRepository;
import com.graphqljava.book.model.Book;

public class GraphQLMutation implements GraphQLRootResolver {
    private final BookRepository BookRepository;

    public GraphQLMutation(BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }

    public Book createBook(String name, int pageCount) {
        Book newBook = new Book(name, pageCount);
        BookRepository.insert(newBook);
        return newBook;
    }
}