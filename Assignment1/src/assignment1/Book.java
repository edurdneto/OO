/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class Book {

    private int callNumber;
    private ArrayList<Author> setAuthor=new ArrayList<>();
    private String title;
    private String publisher;
    private int year;

    public Book(int callNumber, String title, int year) {
        this.callNumber = callNumber;
        this.title = title;
        if(year<1000&&year>9999){
            System.out.println("Invalid year!");
        } else {
             this.year = year;
        }
    }

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public ArrayList<Author> getSetAuthor() {
        return setAuthor;
    }

    public void setSetAuthor(ArrayList<Author> setAuthor) {
        this.setAuthor = setAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int addAuthor(Author a){
        int i=0,insert=0;
        boolean found=false;
        ArrayList<Author> list_Author=this.getSetAuthor();
        list_Author.add(a);
        return insert=1;
    }

    
    public boolean equals(Book obj) {
        return this.callNumber==obj.callNumber&&this.year==obj.year; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Book{" + "callNumber=" + callNumber + ", setAuthor=" + setAuthor + ", title=" + title + ", publisher=" + publisher + ", year=" + year + '}';
    }
   
}
