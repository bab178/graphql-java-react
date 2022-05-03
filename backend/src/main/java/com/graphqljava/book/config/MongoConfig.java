package com.graphqljava.book.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.graphqljava.book.converter.BookWriterConverter;
import com.graphqljava.book.event.BookCascadeSaveMongoEventListener;
import com.graphqljava.book.event.CascadeSaveMongoEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.graphqljava.book.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/" + getDatabaseName());
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.graphqljava.book");
    }

    @Bean
    public BookCascadeSaveMongoEventListener userCascadingMongoEventListener() {
        return new BookCascadeSaveMongoEventListener();
    }

    @Bean
    public CascadeSaveMongoEventListener cascadingMongoEventListener() {
        return new CascadeSaveMongoEventListener();
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new BookWriterConverter());
        return new MongoCustomConversions(converters);
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
