package com.webservices.project.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = IDENTITY, generator = "id_payment")
    private Long id;
    private Instant moment;

    public Payment(Long id, Instant moment, Order order) {
        super();
        this.id = id;
        this.moment = moment;
        //this.order = order;
    }

}
