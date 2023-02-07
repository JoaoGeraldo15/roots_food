package com.food.roots.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class StandardError {
    private LocalDateTime timestamp;

    private Integer status;

    private String message;

    private String path;
}
