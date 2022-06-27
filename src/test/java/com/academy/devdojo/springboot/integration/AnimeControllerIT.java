package com.academy.devdojo.springboot.integration;

import com.academy.devdojo.springboot.domain.Anime;
import com.academy.devdojo.springboot.repository.AnimeRepository;
import com.academy.devdojo.springboot.util.AnimeCreator;
import com.academy.devdojo.springboot.wrapper.PageableResponse;
import org.assertj.core.api.Assertions;
import org.hibernate.transform.CacheableResultTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class AnimeControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("List returns list of anime inside page object when successful")
    void list_ReturnsListOfAnimeInsidePageObject_WhenSuccessful(){
        animeRepository.save(AnimeCreator.createAnimeToBeSaved());
        String expectedName = AnimeCreator.createValidAnime().getName();

        PageableResponse<Anime> animePage = testRestTemplate.exchange("/animes", HttpMethod.GET, null, new ParameterizedTypeReference<PageableResponse<Anime>>() {
        }).getBody();

        Assertions.assertThat(animePage.toList()).isNotEmpty();
        Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
    }

}
