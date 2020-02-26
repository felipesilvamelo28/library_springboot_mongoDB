package com.mongo_test.library.service;

import com.mongo_test.library.dto.AuthorDTO;
import com.mongo_test.library.dto.AuthorDTOSemBooks;
import com.mongo_test.library.dto.BookDTO;
import com.mongo_test.library.dto.CreateBookDTO;
import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;
import com.mongo_test.library.repository.AuthorRepository;
import com.mongo_test.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    @Autowired
    AuthorRepository authorRepository;

    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return BookDTO.converter(books);

    }

    public Book findBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(()-> new RuntimeException("Livro não encontrado!"));
    }

    public BookDTO findById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        return new BookDTO(book.orElseThrow(()-> new RuntimeException("Livro não encontrado!")));
    }

    public Book createBook(CreateBookDTO bookDTO){
        Book newBook = new Book(bookDTO.getName(), bookDTO.getEdition(), bookDTO.getPublicationYear());
        Book bookSaved = bookRepository.save(newBook);
        for(int c = 0; c < bookDTO.getAuthorsId().size(); c++ ){
            Author author = authorService.findAuthorById(bookDTO.getAuthorsId().get(c));
            author.getBooks().add(new BookDTO(bookSaved));
            authorRepository.save(author);
            bookSaved.getAuthors().add(new AuthorDTOSemBooks(author));
        }
        return bookRepository.save(bookSaved);
    }

    public BookDTO updateBook(Book book, String id) {
        Book bookExistent = findBookById(id);
        bookExistent.setName(book.getName());
        bookExistent.setEdition(book.getEdition());
        bookExistent.setPublicationYear(book.getPublicationYear());
        bookRepository.save(bookExistent);
        return new BookDTO(bookExistent);
    }

    public void bookDelete(String id){
        bookRepository.deleteById(id);
    }

}
