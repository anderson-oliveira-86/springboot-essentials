package com.academy.devdojo.springboot.service;

import com.academy.devdojo.springboot.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> listAll(){
        return List.of(new Anime(1L,"Dragon Ball Z") , new Anime(2L,"Yu Yu Hakusho"));
    }

}
