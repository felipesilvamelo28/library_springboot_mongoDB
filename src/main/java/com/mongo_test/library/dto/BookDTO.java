package com.mongo_test.library.dto;

import com.mongo_test.library.entity.Author;
import com.mongo_test.library.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDTO {

    private String id;
    private String name;
    private Double edition;
    private String publicationYear;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.edition = book.getEdition();
        this.publicationYear = book.getPublicationYear();
    }

    public BookDTO() {

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

    public Double getEdition() {
        return edition;
    }

    public void setEdition(Double edition) {
        this.edition = edition;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public static List<BookDTO> converter(List<Book> books){
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }
}
