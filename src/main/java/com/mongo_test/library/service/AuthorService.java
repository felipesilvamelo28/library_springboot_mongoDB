package com.mongo_test.library.service;

import com.mongo_test.library.dto.AuthorDTO;
import com.mongo_test.library.dto.AuthorDTOSemBooks;
import com.mongo_test.library.dto.BookDTO;
import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;
import com.mongo_test.library.repository.AuthorRepository;
import com.mongo_test.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public List<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        return AuthorDTO.converter(authors);

    }

    public AuthorDTO findById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        return new AuthorDTO(author.orElseThrow(()-> new RuntimeException("Livro não encontrado!")));
    }

    public Author findAuthorById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
    }

    public List<BookDTO> findBooksByAuthor(String id) {
        Author author = findAuthorById(id);
        return author.getBooks();
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author createBookByAuthor(Book book, String id){
        Author author = findAuthorById(id);
        book.getAuthors().add(new AuthorDTOSemBooks(author));
        bookRepository.save(book);
        author.getBooks().add(new BookDTO(book));
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author, String id) {
        Author authorExistent = findAuthorById(id);
        authorExistent.setCpf(author.getCpf());
        authorExistent.setName(author.getName());
        return authorRepository.save(authorExistent);
    }

    public void authorDelete(String id){
        authorRepository.deleteById(id);
    }
}
