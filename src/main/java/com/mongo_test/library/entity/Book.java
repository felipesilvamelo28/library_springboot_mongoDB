package com.mongo_test.library.entity;

import com.mongo_test.library.dto.AuthorDTO;
import com.mongo_test.library.dto.AuthorDTOSemBooks;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String name;
    private Double edition;
    private String publicationYear;
    private List<AuthorDTOSemBooks> authors = new ArrayList<>();

    public Book(String name, Double edition, String publicationYear) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.publicationYear = publicationYear;
    }

    public Book() {

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

    public List<AuthorDTOSemBooks> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTOSemBooks> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
