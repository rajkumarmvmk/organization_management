package com.example.siliconvalley_prvtd_lmtd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
    @ResponseStatus
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = CustomException.class)
        public ResponseEntity<ErrorResponse> exception(CustomException exception) {
           ErrorResponse errorResponse = new ErrorResponse(exception.getErrCode(), exception.getErrMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);

        }
      @ExceptionHandler(value = Exception.class)
        public ResponseEntity<?> commonException(Exception exception){
            String message = exception.toString();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

