package org.example.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity

public class Bill {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItemList = new ArrayList<>();
     @Transient  private Customer customer;

    public Bill() {
    }

    public Bill(Long id, Customer customer, List<ProductItem> productItemList, Long customerId, Date billDate) {
        this.id = id;
        this.customer = customer;
        this.productItemList = productItemList;
        this.customerId = customerId;
        this.billDate = billDate;
    }

    public Bill(Customer customer, List<ProductItem> productItemList, Long customerId, Date billDate) {
        this.customer = customer;
        this.productItemList = productItemList;
        this.customerId = customerId;
        this.billDate = billDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProductItemList(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Date getBillDate() {
        return billDate;
    }
}
