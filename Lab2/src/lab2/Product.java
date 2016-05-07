/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author eduardo
 */
public class Product {
    
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + '}';
    }

    public boolean equals(Product p) {
        
        if (this.id != p.id) {
            return false;
        }
        if (!(p.name.equals(this.name))) {
            return false;
        }
        return true;
    }
}
