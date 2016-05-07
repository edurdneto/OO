/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author eduardo
 */
public class Journal {
    private int callNumber;
    private String title;
    private String Organization;
    private int year;

    public Journal() {
    }

    public Journal(int callNumber, String title, int year) {
        this.callNumber = callNumber;
        this.title = title;
        this.year = year;
    }
    
    

    public int getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(int callNumber) {
        this.callNumber = callNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public boolean equals(Journal obj) {
        return this.callNumber==obj.callNumber&&this.year==obj.year; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Journal{" + "callNumber=" + callNumber + ", title=" + title + ", Organization=" + Organization + ", year=" + year + '}';
    }
    
}
