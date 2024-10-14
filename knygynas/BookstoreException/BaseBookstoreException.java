package com.vasarepratuzaite.BookstoreException;

public class BaseBookstoreException extends Exception{

    public BaseBookstoreException(){
        super("Something went wrong!");
        printStackTrace();
    }
    BaseBookstoreException(String str){
        super(str);
    }
}
