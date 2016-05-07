/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author eduardo
 */
public class LibrarySearch {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Book> bookList;
    private ArrayList<Journal> journalList;

    public LibrarySearch() {
        bookList=new ArrayList<>();
        journalList=new ArrayList<>();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(ArrayList<Journal> journalList) {
        this.journalList = journalList;
    }
    
    /**
     * This method will be responsible to add the book b in the bookList.
     * @param b Book
     * @return integer
     */
    public int addBook(Book b){
        int i=0;
        boolean duplicate=false;
        while(i<bookList.size()){
            duplicate=bookList.get(i).equals(b);
            i++;
        }
        if(duplicate){
            System.out.println("Duplicate book!");
            return 0;
        } else {
            bookList.add(b);
            return 1;
        }
    }
    
    /**
     * This method will be responsible to print the bookList.
     */
    public void printListBook(){
        int i=0;
        while(i<this.bookList.size()){
            Book b=bookList.get(i);
            System.out.println("Book:"+i+" CallNumber"+b.getCallNumber()+" Title:"+b.getTitle()+" Year:"+b.getYear());
            i++;
        }
    }
    
    /**
     * This method will be responsible to add the Journal j in the journalList.
     *@param j Journal to be added
     *@return integer
     */
    public int addJournal(Journal j){
        int i=0;
        boolean duplicate=false;
        while(i<journalList.size()){
            duplicate=journalList.get(i).equals(j);
            i++;
        }
        if(duplicate){
            System.out.println("Duplicate journal!");
            return 0;
        } else {
            journalList.add(j);
            return 1;
        }
    }
    
    /**
     * This method will be responsible to print the journalList. 
     */
    public void printListJournal(){
        int i=0;
        while(i<this.journalList.size()){
            Journal j=journalList.get(i);
            System.out.println("Journal:"+i+" CallNumber"+j.getCallNumber()+" Title:"+j.getTitle()+" Year:"+j.getYear());
            i++;
        }
    }

    @Override
    public String toString() {
        return "LibrarySearch{" + "bookList=" + this.bookList + ", journalList=" + this.journalList + '}';
    }
    
    /**
     * This method will be responsible search a book in the bookList.
     * @param callNumber the callNumber to be searched
     * @param title the title to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchBook(int callNumber, String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Book>book_list;
        book_list=this.getBookList();
        System.out.println("Entrei aqui tb");
        for(int i=0;i<book_list.size();i++){
            Book b=book_list.get(i);
            if(b.getCallNumber()==callNumber){
                StringTokenizer key_token = new StringTokenizer(title);
                StringTokenizer title_token = new StringTokenizer(b.getTitle());
                boolean title_bool=false;
                while(key_token.hasMoreTokens()){
                    String key=key_token.nextToken();
                    while(title_token.hasMoreTokens()){
                        if(key.equalsIgnoreCase(title_token.nextToken())){
                            title_bool=true;
                            break;
                        }
                    }
                    if(title_bool==false)break;
                }
                if(title_bool){
                    System.out.println("Entrei aqui tb1");
                    if(pos==-2){
                        if(b.getYear()==startPeriod){
                            b.toString();
                            System.out.println(b.toString());
                        }
                    } else {
                        if(pos!=-1){
                            System.out.println("Entrei aqui tb2:"+b.getYear()+","+startPeriod+","+endPeriod);
                            if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                                System.out.println("Entrei aqui tb3");
                                System.out.println(b.toString());
                            }
                        } else {
                            System.out.println(b.toString());
                        }
                    }
                }
        
            }
        }
    }

    /**
     * This method will be responsible search a journal in the journalList.
     * @param callNumber the callNumber to be searched
     * @param title the title to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchJournal(int callNumber, String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Journal>journal_list;
        journal_list=this.getJournalList();
        for(int i=0;i<journal_list.size();i++){
            Journal j=journal_list.get(i);
            if(j.getCallNumber()==callNumber){
                StringTokenizer key_token = new StringTokenizer(title);
                StringTokenizer title_token = new StringTokenizer(j.getTitle());
                boolean title_bool=false;
                while(key_token.hasMoreTokens()){
                    String key=key_token.nextToken();
                    while(title_token.hasMoreTokens()){
                        if(key.equalsIgnoreCase(title_token.nextToken())){
                            title_bool=true;
                            break;
                        }
                    }
                    if(title_bool==false)break;
                }
                if(title_bool){
                    if(pos==-2){
                        if(j.getYear()==startPeriod){
                            j.toString();
                            System.out.println(j.toString());
                        }
                    } else {
                        if(pos!=-1){
                            if(j.getYear()>=startPeriod&&j.getYear()<=endPeriod){
                                System.out.println(j.toString());
                            }
                        } else {
                            System.out.println(j.toString());
                        }
                    }
                }
            }
        }
    }
    /**
     * This method will be responsible search a book in the bookList.
     * @param callNumber the callNumber to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchBook(int callNumber, int startPeriod, int endPeriod,int pos) {
        ArrayList<Book>book_list;
        book_list=this.getBookList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<book_list.size();i++){
            Book b=book_list.get(i);
            if(b.getCallNumber()==callNumber){
                //System.out.println("Entrei aqui tb1");
                if(pos==-2){
                    if(b.getYear()==startPeriod){
                        b.toString();
                        System.out.println(b.toString());
                    }
                } else {
                    if(pos!=-1){
                        //System.out.println("Entrei aqui tb2:"+b.getYear()+","+startPeriod+","+endPeriod);
                        if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                            //System.out.println("Entrei aqui tb3");
                            System.out.println(b.toString());
                        }
                    } else {
                        System.out.println(b.toString());
                    }
                }
            }
        }
    
    }
    
    /**
     * This method will be responsible search a journal in the journalList.
     * @param callNumber the callNumber to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchJournal(int callNumber, int startPeriod, int endPeriod,int pos) {
        ArrayList<Journal>journal_list;
        journal_list=this.getJournalList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<journal_list.size();i++){
            Journal j=journal_list.get(i);
            if(j.getCallNumber()==callNumber){
                //System.out.println("Entrei aqui tb1");
                if(pos==-2){
                    if(j.getYear()==startPeriod){
                        j.toString();
                        System.out.println(j.toString());
                    }
                } else {
                    if(pos!=-1){
                        //System.out.println("Entrei aqui tb2:"+j.getYear()+","+startPeriod+","+endPeriod);
                        if(j.getYear()>=startPeriod&&j.getYear()<=endPeriod){
                            //System.out.println("Entrei aqui tb3");
                            System.out.println(j.toString());
                        }
                    } else {
                        System.out.println(j.toString());
                    }
                }
            }
        }
    }

    /**
     * This method will be responsible search a book in the bookList.
     * @param title the title to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchBook(String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Book>book_list;
        book_list=this.getBookList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<book_list.size();i++){
            Book b=book_list.get(i);
            StringTokenizer key_token = new StringTokenizer(title);
            StringTokenizer title_token = new StringTokenizer(b.getTitle());
            boolean title_bool=false;
            while(key_token.hasMoreTokens()){
                String key=key_token.nextToken();
                while(title_token.hasMoreTokens()){
                    if(key.equalsIgnoreCase(title_token.nextToken())){
                        title_bool=true;
                        break;
                    }
                }
                if(title_bool==false)break;
            }
            if(title_bool){
                //System.out.println("Entrei aqui tb1");
                if(pos==-2){
                    if(b.getYear()==startPeriod){
                        b.toString();
                        System.out.println(b.toString());
                    }
                } else {
                    if(pos!=-1){
                        //System.out.println("Entrei aqui tb2:"+b.getYear()+","+startPeriod+","+endPeriod);
                        if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                            //System.out.println("Entrei aqui tb3");
                            System.out.println(b.toString());
                        }
                    } else {
                        System.out.println(b.toString());
                    }
                }
            }
        }
    }
    
    /**
     * This method will be responsible search a journal in the journalList.
     * @param title the title to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchJournal(String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Journal>journal_list;
        journal_list=this.getJournalList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<journal_list.size();i++){
            Journal j=journal_list.get(i);
            StringTokenizer key_token = new StringTokenizer(title);
            StringTokenizer title_token = new StringTokenizer(j.getTitle());
            boolean title_bool=false;
            while(key_token.hasMoreTokens()){
                String key=key_token.nextToken();
                while(title_token.hasMoreTokens()){
                    if(key.equalsIgnoreCase(title_token.nextToken())){
                        title_bool=true;
                        break;
                    }
                }
                if(title_bool==false)break;
            }
            if(title_bool){
                //System.out.println("Entrei aqui tb1");
                if(pos==-2){
                    if(j.getYear()==startPeriod){
                        j.toString();
                        System.out.println(j.toString());
                    }
                } else {
                    if(pos!=-1){
                        //System.out.println("Entrei aqui tb2:"+j.getYear()+","+startPeriod+","+endPeriod);
                        if(j.getYear()>=startPeriod&&j.getYear()<=endPeriod){
                            //System.out.println("Entrei aqui tb3");
                            System.out.println(j.toString());
                        }
                    } else {
                        System.out.println(j.toString());
                    }
                }
            }
        }
    }
    
    /**
     * This method will be responsible search a book in the bookList.
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchBook(int startPeriod, int endPeriod,int pos) {
        ArrayList<Book>book_list;
        book_list=this.getBookList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<book_list.size();i++){
            Book b=book_list.get(i);
            //System.out.println("Entrei aqui tb1");
            if(pos==-2){
                if(b.getYear()==startPeriod){
                    b.toString();
                    System.out.println(b.toString());
                }
            } else {
                if(pos!=-1){
                    //System.out.println("Entrei aqui tb2:"+b.getYear()+","+startPeriod+","+endPeriod);
                    if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                        //System.out.println("Entrei aqui tb3");
                        System.out.println(b.toString());
                    }
                } else {
                    System.out.println(b.toString());
                }
            }
        }
    }

    /**
     * This method will be responsible search a journal in the journalList.
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void searchJournal(int startPeriod, int endPeriod,int pos) {
        ArrayList<Journal>journal_list;
        journal_list=this.getJournalList();
        //System.out.println("Entrei aqui tb");
        for(int i=0;i<journal_list.size();i++){
            Journal j=journal_list.get(i);
            if(pos==-2){
                if(j.getYear()==startPeriod){
                    j.toString();
                    System.out.println(j.toString());
                }
            } else {
                if(pos!=-1){
                    //System.out.println("Entrei aqui tb2:"+j.getYear()+","+startPeriod+","+endPeriod);
                    if(j.getYear()>=startPeriod&&j.getYear()<=endPeriod){
                        //System.out.println("Entrei aqui tb3");
                        System.out.println(j.toString());
                    }
                } else {
                    System.out.println(j.toString());
                }
            }
        }
    }
    
}
