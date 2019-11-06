package com.example.dell.apptest;

/**
 * Created by DELL on 02/09/2016.
 */
public class Products {

int id;
String product_name;


    public Products(String product_name) {
        this.product_name = product_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
