package com.backendchallenge.service;

import com.backendchallenge.model.CTF;

import java.util.List;

public interface CTFService {
    List<CTF> findAll();
    List<Integer> getAllIdAnimes();
    CTF findAnimeById(int id);
}
