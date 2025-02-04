package org.example.billingservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private Long id;
    private String firstName;
    private String email;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
