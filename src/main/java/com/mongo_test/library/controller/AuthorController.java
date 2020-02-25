package com.mongo_test.library.controller;

import com.mongo_test.library.dto.AuthorDTO;
import com.mongo_test.library.dto.BookDTO;
import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;
import com.mongo_test.library.service.AuthorService;
import com.mongo_test.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/library/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> findAllAuthors(){
        return authorService.findAll();
    }

    @GetMapping(value = "/{id}")
    public AuthorDTO findById(@PathVariable String id){
        return authorService.findById(id);
    }

    @GetMapping(value = "/{id}/books")
    public List<BookDTO> findBooksByAuthor(@PathVariable String id){
        return authorService.findBooksByAuthor(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @PostMapping(value = "/{id}/books")
    public Author createBookByAuthor(@RequestBody Book book, @PathVariable String id){
        return authorService.createBookByAuthor(book, id);
    }

    @PutMapping(value = "/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable String id){
        return authorService.updateAuthor(author, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAuthor(@PathVariable String id){
        authorService.authorDelete(id);
    }
}
