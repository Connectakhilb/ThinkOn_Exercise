package com.ThinkOn.Skill.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends Exception{

    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}