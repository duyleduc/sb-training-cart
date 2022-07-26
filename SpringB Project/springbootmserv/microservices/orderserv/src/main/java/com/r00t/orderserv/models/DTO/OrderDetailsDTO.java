package com.r00t.orderserv.models.DTO;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDTO {
    private String ID, itemID, status;
    private Integer quantity;
    private Date createdAt, updatedAt;

}
