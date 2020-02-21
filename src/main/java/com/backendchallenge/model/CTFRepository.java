package com.backendchallenge.model;

import com.backendchallenge.model.CTF;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface CTFRepository extends MongoRepository<CTF, String> {
    Collection<CTF> findAllByTypeContains(String type);
}
