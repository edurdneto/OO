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
public class Author {
    private String name;

    public Author() {
    }
    
    public Author(String name) {
        this.name=name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + '}';
    }
    
    
    
}