package com.backendchallenge.service;

import com.backendchallenge.model.CTF;
import com.backendchallenge.repository.CTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTFServiceImpl implements CTFService {

    @Autowired
    private CTFRepository ctfRepository;

    @Override
    public List<CTF> findAll(@RequestParam(name = "limit", required = false) Integer limit, @RequestParam(name = "genre", required = false) String genre) {
        List<CTF> mylist = new ArrayList<>();
        List<CTF> limited = new ArrayList<>();

        for (CTF ctf : ctfRepository.findAll()) {
            if (genre != null && ctf.getGenre().contains(genre)) {
                mylist.add(ctf);
            }
            if (genre == null) {
                mylist.add(ctf);
            }
        }
        if(limit != null){
            for (int i = 0; i < limit ; i++) {
                limited.add(mylist.get(i));
            }
            return limited;
        }

        return mylist;
    }

    @Override
    public List<Integer> getAllIdAnimes() {
        List<Integer> id = new ArrayList<>();
        for (CTF ctf : ctfRepository.findAll()) {
            id.add(ctf.getAnimeId());
        }
        return id;
    }

    @Override
    public CTF findAnimeById(int id) {
        return ctfRepository.findByAnimeId(id);
    }



    @Override
    public List<CTF> topCTF(Integer limit, String genre, String type, String studio, String source, String mainCast) {
        List<CTF> filterList = new ArrayList<>();

        List<CTF> limited = new ArrayList<>();

        for (CTF ctf : ctfRepository.findAll()) {
            if (genre != null && ctf.getGenre().contains(genre)) {
                filterList.add(ctf);
            }
            if (genre == null) {
                filterList.add(ctf);
            }
        }

        filterList = filterList
                .stream()
                .sorted(Comparator.comparing(CTF::getRating).reversed())
                .collect(Collectors.toList());

        if (type != null) {
            filterList = filterList.stream().filter(ctf -> ctf.getType().equals(type)).collect(Collectors.toList());
        }
        if (studio != null ) {
            filterList = filterList.stream().filter(ctf -> ctf.getStudios().equals(studio)).collect(Collectors.toList());
        }
        if (source != null) {
            filterList = filterList.stream().filter(ctf -> ctf.getSource().equals(source)).collect(Collectors.toList());
        }

        if (mainCast != null) {
            filterList = filterList.stream().filter(ctf -> ctf.getMain_cast().contains(mainCast)).collect(Collectors.toList());
        }

        if(limit != null){
            for (int i = 0; i < limit ; i++) {
                limited.add(filterList.get(i));
            }
            return limited;
        }

        return filterList;
    }

    @Override
    public List<Integer> topId(Integer limit, String genre, String type, String studio, String source, String mainCast) {
        List<CTF> filterList;
        filterList = topCTF(limit, genre, type, studio, source, mainCast);
        List<Integer> idList = new ArrayList<>();

        filterList.stream().forEach(ctf-> idList.add(ctf.getAnimeId()));

        return idList;
    }
}
