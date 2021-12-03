package com.webservices.project.model.pk;

import com.webservices.project.model.entities.Order;
import com.webservices.project.model.entities.Product;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
