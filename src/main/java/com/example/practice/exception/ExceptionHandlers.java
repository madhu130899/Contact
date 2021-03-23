package com.example.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = ContactNotFoundException.class)
    public ResponseEntity<Object> exception(ContactNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EmptyFieldException.class)
    public ResponseEntity<Object> FieldException(EmptyFieldException exception)
    {
      //  EmptyFieldException error=new EmptyFieldException()
//        List<String> details=new ArrayList<>();
//        details.add(exception.getMessage());
//        ErrorResponse error=new ErrorResponse("Name not found",details);
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value=PhoneAlreadyExistsException.class)
    public ResponseEntity<Object> Phoneexists(PhoneAlreadyExistsException exception)
    {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }
}




