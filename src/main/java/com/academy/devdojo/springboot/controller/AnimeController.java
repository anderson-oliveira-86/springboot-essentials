package com.academy.devdojo.springboot.controller;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.requests.AnimePostRequestBody;
import com.academy.devdojo.springboot.requests.AnimePutRequestBody;
import com.academy.devdojo.springboot.service.AnimeService;
import com.academy.devdojo.springboot.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<Page<Anime>> list(Pageable pageable){
        return ResponseEntity.ok(animeService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Anime>> listAll(){
        return ResponseEntity.ok(animeService.listAllNoPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findByName(@PathVariable String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody anime){
        return new ResponseEntity<>(animeService.save(anime) , HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
