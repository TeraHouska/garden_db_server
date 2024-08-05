package cz.terahouska.controllers.advice;

import cz.terahouska.services.exceptions.DuplicateEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateEmailExceptionAdvice {
    @ExceptionHandler({DuplicateEmailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleDuplicateEmailException() {}
}
