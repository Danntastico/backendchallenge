package com.backendchallenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "CTF")
public class CTF {
    @Id
    private String id;
    @Field("anime_id")
    private int animeId;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private double rating;
    private String img;
    private String studios;
    private String source;
    private String main_cast;
    private int c1;
    private int c2;
    private int members;

    public CTF() {
    }

    public CTF(String id, int animeId, String name, String genre, String type, int episodes, double rating, String img, String studios, String source, String main_cast, int c1, int c2, int members) {
        this.id = id;
        this.animeId = animeId;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.img = img;
        this.studios = studios;
        this.source = source;
        this.main_cast = main_cast;
        this.c1 = c1;
        this.c2 = c2;
        this.members = members;
    }

}
