package com.graphqljava.book.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import com.querydsl.core.annotations.QueryEntity;

//@QueryEntity
@Document
public class Book {
    @Id
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;

    @Indexed(direction = IndexDirection.ASCENDING)
    private int pageCount;

    @PersistenceConstructor
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
