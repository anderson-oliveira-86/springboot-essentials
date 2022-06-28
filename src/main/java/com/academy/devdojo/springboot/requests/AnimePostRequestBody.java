package com.academy.devdojo.springboot.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty")
    @Schema(description = "This is the Anime's name" , example = "Dragon Ball Z" , required = true)
    private String name;
    @URL(message = "The URL is not valid")
    private String url;
}
