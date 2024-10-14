package com.vasarepratuzaite.Store;

import com.vasarepratuzaite.Books.Book;
import com.vasarepratuzaite.Books.Magazine;
import com.vasarepratuzaite.Books.MagazineExtra;
import com.vasarepratuzaite.Books.Publication;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public abstract class Store{

    public List<Publication> books;
    public boolean discountApplied;

    public Map<String, Integer> quantities = new Hashtable<>();//kad atsimintume kokiai knygai koks quentity liko
    public Store(){
        books = new ArrayList<>();//sukurimas
        books.add(new Book("Poltava", 10.0));//atnaujinimas
        books.add(new Book("Ten kur gieda vėžiai", 15.0));
        books.add(new Book("Pabėgimas iš Šiaurės Korėjos", 20.0));
        books.add(new Book("Dykumų gėlė", 25.0));
        books.add(new Book("Gyvenimo trukmė", 30.0));
        books.add(new Magazine("Barbie magazine", 4.0, new MagazineExtra("Barbie doll", true)));
        books.add(new Magazine("National geography magazine", 4.0, null));
        books.add(new Magazine("Cars magazine", 4.0, new MagazineExtra("Toy car 'Mater'  ", true)));
        for (Publication b:books) {
            quantities.put(b.getTitle(), 10);
        }
        discountApplied = false;
    }

    public Iterator<Publication> iterator(){
        return books.iterator();
    } //factory method
}