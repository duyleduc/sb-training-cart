package com.training.sbtrainingcart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateOrderDto {
    @NotEmpty
    @Size(min = 2, max = 1000,message = "comment should less than 1000 characters")
    private String comment;

    private UpdateOrderDetailDto orderDetail;
}
