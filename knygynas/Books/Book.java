package com.vasarepratuzaite.Books;


import java.text.NumberFormat;
import java.util.Locale;

public class Book extends Publication implements HasPrice {

    private double price;

    public Book(String title, double price) {
        super(title);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    public String toString() {
        NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return title + " - " + priceFormat.format(price);
    }
}