package com.jtwebappyoutube.repositories;

import com.jtwebappyoutube.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
