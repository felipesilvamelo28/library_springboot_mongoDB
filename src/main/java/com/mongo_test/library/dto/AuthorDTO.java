package com.mongo_test.library.dto;

import com.mongo_test.library.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {

    private String id;
    private String name;
    private List<BookDTO> books;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.books = author.getBooks();
    }

    public AuthorDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public static List<AuthorDTO> converter(List<Author> authors){
        return authors.stream().map(AuthorDTO::new).collect(Collectors.toList());
    }
}
