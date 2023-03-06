package com.jtwebappyoutube.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private Long Id;
    private String name;
    private Set<Book> books;
}
