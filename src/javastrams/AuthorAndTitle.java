/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastrams;

import java.util.stream.Stream;

/**
 *
 * @author HASSAN
 */
public class AuthorAndTitle  {
private String author;
private String title;
private long bookId ;
private double price;
private transient static final String  format = 
                      "ID#: %d%n"
                     +"  %s "+  ": %s%n"
                        +"  Price  : $%.2f%n";

    public AuthorAndTitle(String author, String title, long bookId, double price) {
        this.author = author;
        this.title = title;
        this.bookId = bookId;
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public long getBookId() {
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public static String getFormat() {
        return format;
    }

                
   

    @Override
    public String toString() {
        return String.format(format, bookId, title, author,price);
    }

  
    
        
        
}
