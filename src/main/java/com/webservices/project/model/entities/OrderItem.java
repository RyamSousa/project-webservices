package com.webservices.project.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webservices.project.model.pk.OrderItemPK;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {


    private static final long serialVersionUID = 1;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public void setOrder(OrderItemPK id) {
        id.setOrder(id.getOrder());
    }

    public void setProduct(OrderItemPK id) {
        id.setProduct(id.getProduct());
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
