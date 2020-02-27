package com.backendchallenge.service;

import com.backendchallenge.model.CTF;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CTFService {
    List<CTF> findAll(@RequestParam(name = "limit", required = false) Integer limit, @RequestParam(name = "genre", required = false) String genre);
    List<Integer> getAllIdAnimes();
    CTF findAnimeById(int id);
}
