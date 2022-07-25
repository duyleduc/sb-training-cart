package com.training.sbtrainingcart.exceptions;

import com.training.sbtrainingcart.payload.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
public class QuantityIsLargerThanItemInWareHouse extends RuntimeException{
    private ApiResponse apiResponse;

    public QuantityIsLargerThanItemInWareHouse() {
        super();
        String message = String.format("Quantity is larger than Item in warehouse");

        this.apiResponse = new ApiResponse(Boolean.FALSE, message);
    }
}
