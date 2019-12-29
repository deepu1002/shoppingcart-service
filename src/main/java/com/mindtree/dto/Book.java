package com.mindtree.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "Book", discriminatorType = DiscriminatorType.STRING)
public class Book extends Product {
    private String genre;
    private String author;
    private String publications;

    public Book(String category, String name, float price, String genre, String author, String publications) {
        this.setCategory(category);
        this.setName(name);
        this.setPrice(price);
        this.setGenre(genre);
        this.setAuthor(author);
        this.setPublications(publications);

    }
}
