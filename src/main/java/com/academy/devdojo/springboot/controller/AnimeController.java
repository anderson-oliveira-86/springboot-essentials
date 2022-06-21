package com.academy.devdojo.springboot.controller;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Dragon Ball Z") , new Anime("Yu Yu Hakusho"));
    }
}
