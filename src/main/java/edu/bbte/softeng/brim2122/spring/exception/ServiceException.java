package edu.bbte.softeng.brim2122.spring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
