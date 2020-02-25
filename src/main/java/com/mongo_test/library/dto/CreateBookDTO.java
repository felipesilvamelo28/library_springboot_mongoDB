package com.mongo_test.library.dto;

import com.mongo_test.library.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateBookDTO {

    private String name;
    private Double edition;
    private String publicationYear;
    private List<String> authorsId = new ArrayList<>();

    public CreateBookDTO() {
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

    public List<String> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(List<String> authorsId) {
        this.authorsId = authorsId;
    }
}
