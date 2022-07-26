package com.r00t.orderserv.models.DTO;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrdersDTO {
    private String ID, comment;
    private BigInteger userID;
    private String status;
    private Date createdAt, updatedAt;
}
