package com.academy.devdojo.springboot.mapper;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-25T12:57:25-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animeRequestBody) {
        if ( animeRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        return anime;
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animeRequestBody) {
        if ( animeRequestBody == null ) {
            return null;
        }

        Anime anime = new Anime();

        return anime;
    }
}
