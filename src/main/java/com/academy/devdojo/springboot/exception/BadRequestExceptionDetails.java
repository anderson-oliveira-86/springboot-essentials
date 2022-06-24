package com.academy.devdojo.springboot.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {

}
