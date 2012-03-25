package com.mycompany;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
    private final String name;
    private final String price;

    public Product(final String name, final String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}