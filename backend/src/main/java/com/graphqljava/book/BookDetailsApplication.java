package com.graphqljava.book;

import com.graphqljava.book.repository.BookRepository;
import com.graphqljava.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BookDetailsApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookDetailsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        bookRepository.deleteAll();

        // save a couple of books
        bookRepository.save(new Book("Alice", 123));
        bookRepository.save(new Book("Bob", 456));

        // fetch all books
        System.out.println("books found with findAll():");
        System.out.println("-------------------------------");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }
        System.out.println();

        // fetch an individual book
        System.out.println("book found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(bookRepository.findByBookId("Alice"));

        System.out.println("books found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Book book : bookRepository.findByLastName("Smith")) {
            System.out.println(book);
        }

    }

    @Bean
    /** Configures CORS to allow all for graphql endpoints */
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/graphql/**")
                        .allowedOrigins(CorsConfiguration.ALL)
                        .allowedHeaders(CorsConfiguration.ALL)
                        .allowedMethods(CorsConfiguration.ALL);
            }
        };
    }

}