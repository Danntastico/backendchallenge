package com.backendchallenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "model.CTF")
public class CTF {
    @Id
    private String id;
    private int animeId;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private double rating;
    private String img;
    private String studios;
    private String source;
    private String mainCast;
    private int c1;
    private int c2;
    private int members;

    public CTF() {
    }

    public CTF(String id, int animeId, String name, String genre, String type, int episodes, double rating, String img, String studios, String source, String mainCast, int c1, int c2, int members) {
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
        this.mainCast = mainCast;
        this.c1 = c1;
        this.c2 = c2;
        this.members = members;
    }
}
