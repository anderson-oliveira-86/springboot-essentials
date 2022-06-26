package com.academy.devdojo.springboot.requests;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
public class AnimePutRequestBody {
    private Long id;
    private String name;
    @URL(message = "The URL is not valid")
    private String url;
}
