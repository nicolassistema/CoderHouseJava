package com.coderhouse.FacturacionEntregaFinalLetticugna.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String code;
    private Double price;
    private Integer stock;


    //Getters y setters y override methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    //Validators
    public boolean titleValidate(String title) {
        return title != null && title != "";
    }
    public boolean descriptionValidate(String description) {
        return description != null && description != "";
    }
    public boolean codeValidate(String code) {
        return code != null && code != "";
    }
    public boolean priceValidate(Double price) {
        return price != null;
    }
    public boolean stockValidate(Integer stock) {
        return stock != null;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }


}
