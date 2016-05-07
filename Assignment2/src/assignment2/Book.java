/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class Book extends Reference {

    private ArrayList<Author> setAuthor=new ArrayList<>();
    private String publisher;
    
    public Book(int callNumber, String title, int year) {
        super(callNumber, title, year);
    }

    public ArrayList<Author> getSetAuthor() {
        return setAuthor;
    }

    public void setSetAuthor(ArrayList<Author> setAuthor) {
        this.setAuthor = setAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int addAuthor(Author a){
        int i=0,insert=0;
        boolean found=false;
        ArrayList<Author> list_Author=this.getSetAuthor();
        list_Author.add(a);
        return insert=1;
    }

    public String toString() {
        return "Book{" + "callNumber=" + super.getCallNumber() + ", setAuthor=" + setAuthor + ", title=" + super.getTitle() + ", publisher=" + publisher + ", year=" + super.getYear()+ '}';
    }
   
}
