package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GolbalExceptionHandler {
    @ExceptionHandler(TaskException.class)
    public ResponseEntity<MyErrorDetails> studentExcepHandl(TaskException te, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(te.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<MyErrorDetails> studentExcepHandl(UserException ue, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ue.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> ExcepHandl(Exception se, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDetails(req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
