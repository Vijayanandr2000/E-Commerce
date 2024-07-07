package com.example.productservice.controlleradvice;

import com.example.productservice.dto.ExceptionDTO;
import com.example.productservice.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ExceptionDTO> productNotFound(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Product not found");
        exceptionDTO.setSolution("Please try again with a valid product id");

        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(
                exceptionDTO,
                HttpStatus.BAD_REQUEST
        );

        return response;
    }
}
