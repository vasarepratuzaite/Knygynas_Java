package com.vasarepratuzaite.Books;

public abstract class Publication implements Cloneable{

    protected String title;

    public Publication(String title){
        this.title = title;
    }

    final public String getTitle(){
        return title;
    }

    @Override
    public Publication clone(){
        try {
            return (Publication)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
