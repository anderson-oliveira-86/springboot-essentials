package com.academy.devdojo.springboot.requests;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty")
    private String name;
    @URL(message = "The URL is not valid")
    private String url;
}
