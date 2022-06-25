package com.academy.devdojo.springboot.client;

import com.academy.devdojo.springboot.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity(URI.create("http://localhost:8080/animes/2"), Anime.class );
        log.info(entity);

        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Anime>>() {});
        log.info(exchange.getBody());

        Anime kingdom = Anime.builder()
                .name("kingdom")
                .url("http://localhost:8080/animes/all")
                .build();
        Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes" , kingdom , Anime.class);
        log.info("saved anime {}" ,kingdomSaved);

        Anime samurai = Anime.builder()
                .name("samurai")
                .url("http://localhost:8080/animes/all")
                .build();
        ResponseEntity<Anime> samuraiSaved = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.POST, new HttpEntity<>(samurai , createJsonHeader()), Anime.class);
        log.info("saved anime {}" ,samuraiSaved);

        Anime animeSaved = samuraiSaved.getBody();
        animeSaved.setName("Samurai update");

        ResponseEntity<Void> samuraiUpdate = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.PUT, new HttpEntity<>(animeSaved , createJsonHeader()), Void.class);
        log.info("update anime {}" ,samuraiUpdate);


        ResponseEntity<Void> samuraiDelete = new RestTemplate().exchange("http://localhost:8080/animes/21", HttpMethod.DELETE, null, Void.class);
        log.info("delete anime {}" ,samuraiDelete);

    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
