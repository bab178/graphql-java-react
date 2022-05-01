package com.graphqljava.book.database;

import com.graphqljava.book.model.Book;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookWriterConverter implements Converter<Book, DBObject> {

    @Override
    public DBObject convert(final Book Book) {
        final DBObject dbObject = new BasicDBObject();
        dbObject.put("name", Book.getName());
        dbObject.put("pageCount", Book.getPageCount());
//        if (Book.getEmailAddress() != null) {
//            final DBObject emailDbObject = new BasicDBObject();
//            emailDbObject.put("value", Book.getEmailAddress().getValue());
//            dbObject.put("email", emailDbObject);
//        }
        dbObject.removeField("_class");
        return dbObject;
    }

}