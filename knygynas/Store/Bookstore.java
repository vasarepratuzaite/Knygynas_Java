package com.vasarepratuzaite.Store;

import com.vasarepratuzaite.Books.HasPrice;
import com.vasarepratuzaite.Books.Publication;
import com.vasarepratuzaite.BookstoreException.LettersCantBeRead;
import com.vasarepratuzaite.Customer.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bookstore extends Store{

    private float discountAmount = (float)0.9;

    public Bookstore(){
        super();
    }


    public void openStore(Scanner scanner, Customer customer) throws LettersCantBeRead{
        System.out.print("Enter the book number you want to buy (0 to finish): ");
        try {
            int selectedBookNumber = scanner.nextInt();

            while (selectedBookNumber != 0) {
                if(selectedBookNumber < 0){
                    System.out.println("Negative numbers are not accepted");

                }else {
                    System.out.print("How many units do you want to buy: ");
                    int quantity = scanner.nextInt();

                    boolean selectedBook = this.buyBook(customer, selectedBookNumber, quantity);
                    if (!selectedBook) {
                        System.out.println("The book is not in the list or there is not enough quantity.");
                    }
                }
                System.out.print("Enter the number of another book you want to buy (0 to finish): ");
                selectedBookNumber = scanner.nextInt();
            }
        }catch (InputMismatchException e){
            throw new LettersCantBeRead();
        }
    }
    public boolean buyBook(Customer customer, int bookNumber, int quantity){
        if (bookNumber >= 0 && bookNumber - 1 < books.size()) {
            Publication publication = books.get(bookNumber - 1);
            int availableQuantity = quantities.get(publication.getTitle());
            if (availableQuantity >= quantity) {
                for (int i = 0; i < quantity; i++) {
                    quantities.put(publication.getTitle(), availableQuantity - (i + 1));
                    customer.purchasedBooks.add(publication.clone()); //prototype
                }
                return true;
            }
        }
        return false;
    }

    public void checkDiscountCode(String code, Customer currentCustomer){
        if ("BUY".equals(code)) {
            this.applyDiscount(currentCustomer);
            System.out.println("10% discount applied.");
        }else{
            System.out.println("No such discount code exist.");
        }
    }
    private void applyDiscount(Customer currentCustomer){
        for (int i = 0; i < currentCustomer.purchasedBooks.size(); i++) {
            HasPrice book = (HasPrice) currentCustomer.purchasedBooks.get(i);
            double discountedPrice = book.getPrice();
            discountedPrice *= discountAmount;
            book.setPrice(discountedPrice);
        }
    }
    public double  calculateTotal(Customer customer){ //proxy
        return customer.calculateTotal();
    }
}