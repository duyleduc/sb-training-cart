package com.training.sbtrainingcart.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="order_id")
//    @Size( max = 16)
    private String  orderId;

    @Column(name = "user_id",updatable = false)
    @NotNull
    private long userId;

    @Column(name = "comment")
    @Size(max = 1000)
    private String comment;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private OrderDetail orderDetail;
}
