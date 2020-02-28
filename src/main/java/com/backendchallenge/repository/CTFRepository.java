package com.backendchallenge.repository;

import com.backendchallenge.model.CTF;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CTFRepository extends MongoRepository<CTF, String> {
    CTF findByAnimeId(int x);
}
