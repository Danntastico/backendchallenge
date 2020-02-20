package com.backendchallenge.Controller;

import com.backendchallenge.model.CTF;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("CTF/api")
public class CTFController {
    private MongoTemplate mongoTemplate;

    public CTFController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @GetMapping("/all")
    public Collection<CTF> all(){ return this.mongoTemplate.findAll(CTF.class);}
}
