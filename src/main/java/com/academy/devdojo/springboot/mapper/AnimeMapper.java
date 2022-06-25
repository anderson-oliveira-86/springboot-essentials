package com.academy.devdojo.springboot.mapper;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;

public class AnimeMapper {

    public static Anime toAnime(AnimePutRequestBody animeRequestBody){
        return Anime.builder()
                .id(animeRequestBody.getId())
                .name(animeRequestBody.getName())
                .url(animeRequestBody.getUrl())
                .build();
    };
    public static Anime toAnime(AnimePostRequestBody animeRequestBody){
        return Anime.builder()
                .name(animeRequestBody.getName())
                .url(animeRequestBody.getUrl())
                .build();
    };
}
