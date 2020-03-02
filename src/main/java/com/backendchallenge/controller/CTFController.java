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

    @GetMapping("GET/anime/top")
    public List<Integer> topId(@RequestParam(name = "limit", required = false) Integer limit,
                               @RequestParam(name = "genre", required = false) String genre,
                               @RequestParam(name = "type", required = false) String type,
                               @RequestParam(name = "studio", required = false) String studio,
                               @RequestParam(name = "source", required = false) String source,
                               @RequestParam(name = "mainCast", required = false) String mainCast){
        return ctfService.topId(limit, genre, type, studio,source, mainCast);
    }
}
