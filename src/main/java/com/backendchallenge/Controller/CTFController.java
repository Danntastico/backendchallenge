package com.backendchallenge.Controller;

import com.backendchallenge.model.CTF;
import com.backendchallenge.model.CTFRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("CTF/api")
public class CTFController {
    private CTFRepository ctfRepository;

    public CTFController(CTFRepository ctfRepository) {
        this.ctfRepository = ctfRepository;
    }

    @GetMapping("/all")
    public Collection<CTF> all(){ return this.ctfRepository.findAll();}

    @GetMapping("/{id}")
    public CTF byId(@PathVariable String id){
        return this.ctfRepository.findById(id).orElse(null);    
    }

    @GetMapping("/byType/{type}")
    public Collection<CTF> byType(@PathVariable String type){
        //return this.ctfRepository.findAllByTypeContains(type);
        return null;
    }
}
