package com.mindtree.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "Book", discriminatorType = DiscriminatorType.STRING)
public class Book extends Product {
    @Column(name = "GENRE")
    private String genre;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATIONS")
    private String publications;

    public Book(String category, String name, float price, String genre, String author, String publications) {
        this.setCategory(category);
        this.setName(name);
        this.setPrice(price);
        this.setGenre(genre);
        this.setAuthor(author);
        this.setPublications(publications);
    }

    @Override
    public String toString() {
        return "Book{" + "genre='" + genre + '\'' + ", author='" + author + '\'' + ", publications='" + publications + '\'' + '}';
    }
}
