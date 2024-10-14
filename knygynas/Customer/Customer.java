package com.vasarepratuzaite.Customer;

import com.vasarepratuzaite.Books.HasPrice;
import com.vasarepratuzaite.Books.Publication;

import java.util.ArrayList;
import java.util.List;

public class Customer{
    public List<Publication> purchasedBooks = new ArrayList<>();
    double total;

    public double calculateTotal(){

        total = purchasedBooks.stream()
                .filter(a -> a instanceof HasPrice) //perziurint paliekami tik tie kas  implementuoja interface
                .map(a -> {
                    System.out.println(a);
                    return ((HasPrice)a).getPrice();
                })
                .reduce((a,b) -> a + b)
                .orElse(0.0);

        return total;
    }
}
