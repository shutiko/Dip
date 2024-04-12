package com.example.diplom.dto;

import lombok.Data;

@Data
public class ErrorDto {
    private Integer id = 0;
    private final String errorMessage;

    public ErrorDto(String message) {
        //this.id = IdGenerator.generateId();
        this.id = id++;
        this.errorMessage = message;
    }
}
