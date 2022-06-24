package com.academy.devdojo.springboot.service;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.exception.BadRequestException;
import com.academy.devdojo.springboot.mapper.AnimeMapper;
import com.academy.devdojo.springboot.repository.AnimeRepository;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }
    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findById(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime Id not found"));
    }

    @Transactional(rollbackFor = Exception.class) // annotation for rollback in the database if was thrown exception
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.deleteById(id);
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findById(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
