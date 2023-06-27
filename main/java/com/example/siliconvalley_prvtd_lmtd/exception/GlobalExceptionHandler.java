package com.example.siliconvalley_prvtd_lmtd.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
    @ResponseStatus
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = CustomException.class)
        public ResponseEntity<ErrorResponse> exception(CustomException exception) {
            ErrorResponse errorResponse = new ErrorResponse(exception.getErrCode(), exception.getErrMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);

        }
      @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity<?> commonException(MethodArgumentNotValidException exception){
                    ErrorResponse errorResponse = new ErrorResponse("CODE_605","your field for entry is black");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> commonException(Exception exception){
        String message = exception.toString();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    }


