package com.mongo_test.library.controller;

import com.mongo_test.library.dto.BookDTO;
import com.mongo_test.library.dto.CreateBookDTO;
import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;
import com.mongo_test.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/library/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> findAllBooks(){
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public BookDTO findById(@PathVariable String id){
        return bookService.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody CreateBookDTO book){
       return bookService.createBook(book);
    }

    @PutMapping(value = "/{id}")
    public BookDTO updateBook(@RequestBody Book book, @PathVariable String id){
        return bookService.updateBook(book, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.bookDelete(id);
    }

}
