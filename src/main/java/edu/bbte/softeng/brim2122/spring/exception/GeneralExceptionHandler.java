package edu.bbte.softeng.brim2122.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadRequest(BadRequestException e) {
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleNotFound(NotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRepository(ServiceException e) {
        return e.getMessage();
    }
}
