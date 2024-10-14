package com.vasarepratuzaite;

import com.vasarepratuzaite.Books.Publication;
import com.vasarepratuzaite.Customer.Customer;
import com.vasarepratuzaite.Store.Bookstore;
import com.vasarepratuzaite.BookstoreException.LettersCantBeRead;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Books list:");

        int i = 0;
        Publication b;
        //perziureti su for'u
        for (Iterator<Publication> it = bookstore.iterator(); it.hasNext();) {

                b = it.next();
                System.out.println(i + 1 + ". " + b + " Quantity left: " + bookstore.quantities.get(b.getTitle()));
                //System.out.println("Gyvenimo trukmė:" bookstore.iterator(b));
                i++;
        }

        try {
            bookstore.openStore(scanner, customer);
        } catch (LettersCantBeRead e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter the discount code: ");

        String discountCode = scanner.next();
        bookstore.checkDiscountCode(discountCode, customer);

        System.out.println("Your purchase list:");
        double totalCost = bookstore.calculateTotal(customer); // proxy

        NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        System.out.println("Total cost: " + priceFormat.format(totalCost));

    }
}