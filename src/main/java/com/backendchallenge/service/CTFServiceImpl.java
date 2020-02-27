package com.backendchallenge.service;

import com.backendchallenge.model.CTF;
import com.backendchallenge.repository.CTFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTFServiceImpl implements CTFService {
    @Autowired
    private CTFRepository ctfRepository;

    @Override
    public List<CTF> findAll(@RequestParam(name = "limit", required = false) Integer limit, @RequestParam(name = "genre", required = false) String genre) {
        List<CTF> mylist = new ArrayList<>();
        if (limit != null) {
            for (int i = 0; i <= limit; i++) {
                if (genre != null && ctfRepository.findAll().get(i).getGenre().contains(genre)) {
                    mylist.add(ctfRepository.findAll().get(i));
                }
                if (genre == null) {
                    mylist.add(ctfRepository.findAll().get(i));
                }
            }
            return mylist;
        }
        else {
            for (CTF ctf : ctfRepository.findAll()) {
                if (genre != null && ctf.getGenre().contains(genre)) {
                    mylist.add(ctf);
                } else {
                    mylist.add(ctf);
                }

            }
            return this.ctfRepository.findAll();
        }
    }

    @Override
    public List<Integer> getAllIdAnimes() {
        List<Integer> id = new ArrayList<>();
        for(CTF ctf : ctfRepository.findAll()){
            id.add(ctf.getAnimeId());
        }
        return id;
    }

    @Override
    public CTF findAnimeById(int id) {
        for (CTF ctf : ctfRepository.findAll()){
            if (ctf.getAnimeId() == id){
                return ctf;
            }
        }
        return null;
    }
}
