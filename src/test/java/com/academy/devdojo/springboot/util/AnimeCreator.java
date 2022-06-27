package com.academy.devdojo.springboot.util;

import com.academy.devdojo.springboot.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .name("AnimeTest")
                .url("http://localhost:8080/animes")
                .build();
    }

    public static Anime createValidAnime(){
        return Anime.builder()
                .id(1L)
                .name("AnimeTest")
                .url("http://localhost:8080/animes")
                .build();
    }

    public static Anime createValidUpdateAnime(){
        return Anime.builder()
                .id(1L)
                .name("Anime test update")
                .url("http://localhost:8080/animes")
                .build();
    }
}
