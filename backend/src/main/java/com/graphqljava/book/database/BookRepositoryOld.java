package com.graphqljava.book.database;

import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

//import org.springframework.data.mongodb.repository.MongoRepository;

import com.graphqljava.book.model.Book;

public class BookRepositoryOld { // extends MongoRepository<Book, String> {
    private final MongoCollection<Document> Books;

    BookRepositoryOld(MongoCollection<Document> Books) {
        this.Books = Books;
    }

//    public Book findById(String id) {
//        Document doc = Books.find(eq("_id", new ObjectId(id))).first();
//        return Book(doc);
//    }

//    public List<Book> getAllBooks(BookFilter filter, int skip, int first) {
//        Optional<Bson> mongoFilter = Optional.ofNullable(filter).map(this::buildFilter);
//
//        List<Book> allBooks = new ArrayList<>();
//        FindIterable<Document> documents = mongoFilter.map(Books::find).orElseGet(Books::find);
//        for (Document doc : documents.skip(skip).limit(first)) {
//            allBooks.add(Book(doc));
//        }
//        return allBooks;
//    }
//
//    public void saveBook(Book Book) {
//        Document doc = new Document();
//        doc.append("name", Book.getName());
//        doc.append("pageCount", Book.getPageCount());
//        Books.insertOne(doc);
//    }
//
//    private Bson buildFilter(BookFilter filter) {
//        String descriptionPattern = filter.getDescriptionContains();
//        String urlPattern = filter.getUrlContains();
//        Bson descriptionCondition = null;
//        Bson urlCondition = null;
//        if (descriptionPattern != null && !descriptionPattern.isEmpty()) {
//            descriptionCondition = regex("description", ".*" + descriptionPattern + ".*", "i");
//        }
//        if (urlPattern != null && !urlPattern.isEmpty()) {
//            urlCondition = regex("url", ".*" + urlPattern + ".*", "i");
//        }
//        if (descriptionCondition != null && urlCondition != null) {
//            return and(descriptionCondition, urlCondition);
//        }
//        return descriptionCondition != null ? descriptionCondition : urlCondition;
//    }
//
//    private Book Book(Document doc) {
//        return new Book(
//                doc.get("_id").toString(),
//                doc.getString("name"),
//                doc.getString("pageCount"));
//    }
}
