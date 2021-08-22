package com.moon.lambda;

/**
 * Created by Moon on 21/08/2021
 */
public class Product {
    public  int id;
    public  String name;
    public   float price;
        public Product(int id, String name, float price) {
            super();
            this.id = id;
            this.name = name;
            this.price = price;
        }

    public Product(int id, String potatoes) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
