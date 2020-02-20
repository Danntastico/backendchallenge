package com.backendchallenge.persistence;

import com.backendchallenge.model.CTF;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CTFRepository extends MongoRepository<CTF, String> {
}
