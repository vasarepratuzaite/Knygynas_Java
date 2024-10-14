package com.vasarepratuzaite.BookstoreException;

public class LettersCantBeRead extends BaseBookstoreException{
    public LettersCantBeRead(){
        super("Letters are an illegal input");
    }
}
