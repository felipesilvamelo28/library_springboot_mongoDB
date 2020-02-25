package com.mongo_test.library.dto;

import com.mongo_test.library.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTOSemBooks {

    private String id;
    private String name;

    public AuthorDTOSemBooks(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }

    public AuthorDTOSemBooks() {
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

    public static List<AuthorDTOSemBooks> converter(List<Author> authors){
        return authors.stream().map(AuthorDTOSemBooks::new).collect(Collectors.toList());
    }
}
