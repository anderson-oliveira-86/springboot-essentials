package com.academy.devdojo.springboot.util;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .name(AnimeCreator.createValidAnime().getName())
                .url(AnimeCreator.createValidAnime().getUrl())
                .build();
    }
}
