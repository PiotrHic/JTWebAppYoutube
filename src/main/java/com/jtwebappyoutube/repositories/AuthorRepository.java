package com.jtwebappyoutube.repositories;

import com.jtwebappyoutube.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
