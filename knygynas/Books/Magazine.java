package com.vasarepratuzaite.Books;

import java.text.NumberFormat;
import java.util.Locale;

public class Magazine extends Publication implements HasPrice, Cloneable{

    MagazineExtra extra;
    double price;

    public Magazine(String title, double price, MagazineExtra extra){
        super(title);
        this.price = price;
        this.extra = extra;
    }

    public String toString(){
        NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        return title + " - " + priceFormat.format(price);
    }

    public double getPrice(){
        return price;
    }

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public Magazine clone(){
        Magazine clone = (Magazine)super.clone();
        if (this.extra != null) {
            clone.extra = new MagazineExtra(this.extra.name, this.extra.isForKids);
        }else {
            clone.extra = null;
        }
        return clone;
    }
}