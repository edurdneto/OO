/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author eduardo
 */
public class Journal extends Reference {
    private String Organization;

    public Journal(int callNumber, String title, int year) {
        super(callNumber, title, year);
    }
    
    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    
    @Override
    public String toString() {
        return "Journal{" + "callNumber=" + super.getCallNumber() + ", title=" + super.getTitle() + ", Organization=" + Organization + ", year=" + super.getYear() + '}';
    }
    
}
