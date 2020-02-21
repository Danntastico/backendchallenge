package com.backendchallenge.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CTFRepository extends MongoRepository<CTF, String> {
}
