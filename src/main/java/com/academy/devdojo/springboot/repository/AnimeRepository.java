package com.academy.devdojo.springboot.repository;

import com.academy.devdojo.springboot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime , Long> {

}
