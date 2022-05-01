package com.graphqljava.book.model;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private final String id;
    private final String name;
    private final int pageCount;

    public Book(String name, int pageCount) {
        this(null, name, pageCount);
    }

    public Book(String id, String name, int pageCount) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPageCount() {
        return pageCount;
    }
}
