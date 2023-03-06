package com.jtwebappyoutube.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
public class Author {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String name, Set<Book> books, Set<Book> books1) {
        this.name = name;
        this.books = books;
        this.books = books1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(Id, author.Id);
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
