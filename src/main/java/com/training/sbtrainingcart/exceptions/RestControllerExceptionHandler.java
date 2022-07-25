package com.training.sbtrainingcart.exceptions;

import com.training.sbtrainingcart.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(ResourceNotFoundException exception){
        ApiResponse apiResponse = exception.getApiResponse();

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceIsAlreadyTakenException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(ResourceIsAlreadyTakenException exception){
        ApiResponse apiResponse = exception.getApiResponse();

        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(QuantityIsLargerThanItemInWareHouse.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> resolveException(QuantityIsLargerThanItemInWareHouse exception){
        ApiResponse apiResponse = exception.getApiResponse();

        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
}
