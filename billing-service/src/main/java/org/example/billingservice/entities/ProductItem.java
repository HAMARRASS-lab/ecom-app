package org.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity

public class ProductItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitPrice;

    @Transient private Product product;

    public ProductItem(Long id, Product product, double unitPrice, Bill bill, int quantity, String productId) {
        this.id = id;
        this.product = product;
        this.unitPrice = unitPrice;
        this.bill = bill;
        this.quantity = quantity;
        this.productId = productId;
    }

    public ProductItem(Product product, String productId, Bill bill, int quantity, double unitPrice) {
        this.product = product;
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ProductItem() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Bill getBill() {
        return bill;
    }

    public String getProductId() {
        return productId;
    }
}
