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
public abstract class Reference {
    private int callNumber;
    private String title;
    private int year;
    
    public Reference(int callNumber, String title, int year) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * This method will be responsible to determine when an object of the class reference
     * is equal to another object of the same class.
     *@param obj Object to be compared 
     *@return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reference other = (Reference) obj;
        if (this.callNumber != other.callNumber) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public abstract String toString();
    

}

