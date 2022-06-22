package com.academy.devdojo.springboot.mapper;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animeRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animeRequestBody);
}
