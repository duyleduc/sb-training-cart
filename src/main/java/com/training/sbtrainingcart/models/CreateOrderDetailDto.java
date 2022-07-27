package com.training.sbtrainingcart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateOrderDetailDto {
    private String  orderDetailId;

    @NotEmpty
    @Size(min = 1, max = 8,message = "item ID should have more than 1 character and less than 8 characters")
    private String itemId;

    @Column(name = "user_id",updatable = false)
    @NotNull
    @Pattern(regexp="[0-9]+",message = "quantity should be number")
    private long quantity;

    @NotEmpty
    @Size( max = 64,message = "status should less than 64 characters")
    private String status;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


}
