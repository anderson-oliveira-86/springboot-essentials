package com.academy.devdojo.springboot.client;

import com.academy.devdojo.springboot.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity(URI.create("http://localhost:8080/animes/2"), Anime.class );
        log.info(entity);
    }
}
