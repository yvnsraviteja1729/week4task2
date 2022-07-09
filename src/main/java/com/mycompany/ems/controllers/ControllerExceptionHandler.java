package com.mycompany.ems.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.validation.ValidationException;
//
//@ControllerAdvice
//public class ControllerExceptions {
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(EmptyInputException.class)
//    EmptyInputException exceptionHandler(EmptyInputException e) {
//        return new ErrorMessage("400", e.getMessage());
//
//    }
//}

//package com.wiredbrain.friends.controllers;

import javax.validation.ValidationException;

import com.mycompany.ems.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e) {
        return new ErrorMessage("400", e.getMessage());

    }
}
