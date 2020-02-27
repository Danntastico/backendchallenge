package com.backendchallenge.controller;

import com.backendchallenge.model.CTF;
import com.backendchallenge.service.CTFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CTF")
public class CTFController {
    @Autowired
    private CTFService ctfService;

    @GetMapping("GET/all")
    public List<CTF> getAllAnimes(@RequestParam(name = "limit", required = false) Integer limit, @RequestParam(name = "genre", required = false) String genre){
        return ctfService.findAll(limit, genre);
    }

    @GetMapping("GET/anime")
    public List<Integer> getAllId(){
        return ctfService.getAllIdAnimes();
    }

    @GetMapping("GET/anime/{anime_id}")
    public CTF byId(@PathVariable int anime_id){
        return ctfService.findAnimeById(anime_id);
    }
}
