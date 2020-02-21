package com.backendchallenge.model;

import java.util.List;

public interface CTFService {
    List<CTF> findAll();
    List<Integer> getAllIdAnimes();
    CTF findAnimeById(int id);
}
