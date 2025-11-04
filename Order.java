package com.example.demo.model;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private double amount;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Order(){}

    public Order(String productName, double amount,User user){
        this.productName = productName;
        this.amount = amount;
        this.user = user;
    }
    public int getId(){return id;}
    public void setID(int id){this.id = id;}

    public String getProductName(){return productName;}
    public void setProductName(String productName){this.productName = productName;}

    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount= amount;}

    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}
}
