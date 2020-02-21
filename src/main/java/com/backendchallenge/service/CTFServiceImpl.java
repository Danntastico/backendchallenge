package com.backendchallenge.service;

import com.backendchallenge.model.CTF;
import com.backendchallenge.repository.CTFRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CTFServiceImpl implements CTFService {
    @Autowired
    private CTFRepository ctfRepository;

    @Override
    public List<CTF> findAll() {
        return this.ctfRepository.findAll();
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
