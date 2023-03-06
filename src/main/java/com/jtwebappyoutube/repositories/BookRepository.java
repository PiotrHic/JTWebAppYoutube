package com.jtwebappyoutube.repositories;

import com.jtwebappyoutube.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
