package com.mongo_test.library.config;

import com.mongo_test.library.dto.AuthorDTO;
import com.mongo_test.library.dto.AuthorDTOSemBooks;
import com.mongo_test.library.dto.BookDTO;
import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;
import com.mongo_test.library.repository.AuthorRepository;
import com.mongo_test.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {

        bookRepository.deleteAll();
        authorRepository.deleteAll();

        Book book1 = new Book("Livro teste 1", 2.5, "2020");
        Book book2 = new Book("Livro teste 2", 2.5, "2020");
        Book book3 = new Book("Livro teste 3", 2.5, "2020");

        Author author1 = new Author(null, "Autor Teste 1", "078273919");
        Author author2 = new Author(null, "Autor Teste 2", "078273919");
        Author author3 = new Author(null, "Autor Teste 3", "078273919");

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));

        AuthorDTOSemBooks authorDTO1 = new AuthorDTOSemBooks(author1);
        AuthorDTOSemBooks authorDTO2 = new AuthorDTOSemBooks(author2);
        AuthorDTOSemBooks authorDTO3 = new AuthorDTOSemBooks(author3);

        book1.getAuthors().addAll(Arrays.asList(authorDTO1, authorDTO2));
        book2.getAuthors().addAll(Arrays.asList(authorDTO1, authorDTO3));
        book3.getAuthors().addAll(Arrays.asList(authorDTO2));

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

        author1.getBooks().addAll(Arrays.asList(new BookDTO(book1), new BookDTO(book2)));
        author2.getBooks().addAll(Arrays.asList(new BookDTO(book1), new BookDTO(book3)));
        author3.getBooks().addAll(Arrays.asList(new BookDTO(book2)));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));




    }
}
