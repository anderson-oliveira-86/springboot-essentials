package com.academy.devdojo.springboot.repository;

import com.academy.devdojo.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
