package com.gulukal.blogspringtrestapi.exception;


import com.gulukal.blogspringtrestapi.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    //handle specific exceptions   -FOR RESOURCENOTFOUND
    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //handle specific exceptions   -FOR BLOGAPIEXCEPTION
    @ExceptionHandler(BlogApiException.class)

    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(BlogApiException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    //global exceptions


}
