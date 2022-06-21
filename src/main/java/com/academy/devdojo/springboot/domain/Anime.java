package com.academy.devdojo.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Anime {
    private Long id;
    private String name;

}
