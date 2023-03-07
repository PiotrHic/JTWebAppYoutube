package com.jtwebappyoutube.repositories;

import com.jtwebappyoutube.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
