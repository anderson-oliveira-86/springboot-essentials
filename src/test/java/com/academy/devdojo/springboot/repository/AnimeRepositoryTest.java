package com.academy.devdojo.springboot.repository;

import com.academy.devdojo.springboot.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("test for Anime Repository")
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime when Successful")
    public void save_PersistAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
    }

    @Test
    @DisplayName("Save updates anime when Successful")
    public void save_UpdateAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        animeSaved.setName("Anime test update");
        Anime animeUpdated = this.animeRepository.save(animeSaved);
        Assertions.assertThat(animeUpdated).isNotNull();
        Assertions.assertThat(animeUpdated.getId()).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeSaved.getName());
    }

    @Test
    @DisplayName("Delete removes anime when Successful")
    public void delete_RemovesAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        this.animeRepository.delete(animeSaved);
        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());
        Assertions.assertThat(animeOptional).isEmpty();
    }

    @Test
    @DisplayName("Find By Name returns list of anime when Successful")
    public void findByName_ReturnsListOfAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        String name = animeSaved.getName();
        List<Anime> animeList = this.animeRepository.findByName(name);
        Assertions.assertThat(animeList)
                .isNotEmpty()
                .contains(animeSaved);

    }

    @Test
    @DisplayName("Find By Name returns empty list when anime is not found")
    public void findByName_ReturnsEmptyList_WhenAnimeIsNotFound(){
        List<Anime> animeList = this.animeRepository.findByName("notFound");
        Assertions.assertThat(animeList).isEmpty();

    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    public void save_ThrowConstraintViolationException_WhenNameIsEmpty(){
        Anime animeNameIsEmpty = Anime.builder().url("http://localhost:8080/animes").build();
        Assertions.assertThatThrownBy(() -> this.animeRepository.save(animeNameIsEmpty))
                .isInstanceOf(ConstraintViolationException.class);

    }

    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty two")
    public void save_ThrowConstraintViolationException_WhenNameIsEmptyTwo(){
        Anime animeUrlIsInvalid = Anime.builder().url("http://localhost:8080/animes").build();
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.animeRepository.save(animeUrlIsInvalid))
                .withMessageContaining("The anime name cannot be empty");

    }

    private Anime createAnime(){
        return Anime.builder()
                .name("Anime test")
                .url("http://localhost:8080/animes")
                .build();
    }
}