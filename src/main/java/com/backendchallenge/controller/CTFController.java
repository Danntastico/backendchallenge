package com.backendchallenge.controller;

import com.backendchallenge.model.CTF;
import com.backendchallenge.service.CTFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CTF")
public class CTFController {
    @Autowired
    private CTFService ctfService;

    @GetMapping("GET/all")
    public List<CTF> getAllAnimes(){
        return ctfService.findAll();
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
