package com.webservices.project.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservices.project.model.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = IDENTITY, generator = "id_order")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        super();
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus.getCode());
        this.client = client;
    }

}
