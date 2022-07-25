package com.training.sbtrainingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail  {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="detail_id")
//    @Size( max = 16)
    private String  orderDetailId;

    @Column(name = "item_id",updatable = false )
    @Size(max = 8)
    private String itemId;

    @Column(name = "quantity",updatable = false)
    @NotNull
    private long quantity;

    @Column(name = "status")
    @Size(max = 64)
    private String status;

    @Column(name="created_date",updatable = false)
    private LocalDateTime createdDate;

    @Column(name="modified_date")
    private LocalDateTime modifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }


    @OneToOne(mappedBy = "orderDetail",fetch = FetchType.EAGER)
    private Order order;
}
