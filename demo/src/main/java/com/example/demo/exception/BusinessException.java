package com.example.demo.exception;

import com.example.demo.exception.message.ErrorMessage;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
