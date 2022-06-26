package com.academy.devdojo.springboot.util;

import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody createAnimePostRequestBody(){
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .url(AnimeCreator.createValidAnime().getUrl())
                .build();
    }
}
