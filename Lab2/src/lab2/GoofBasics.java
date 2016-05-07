/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class GoofBasics {
    private int id;
    private String name;
    ArrayList<Product> productList=new ArrayList<>();
    ArrayList<Employee> employeeList=new ArrayList<>();

    public GoofBasics(int id, String name) {
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

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "GoofBasics{" + "id=" + id + ", name=" + name + ", productList=" + productList + ", employeeList=" + employeeList + '}';
    }
    
    public String toStringProductList() {
        return "Product List=" + productList;
    }
    
    public String toStringEmployeeList() {
        return "Employee List=" + employeeList;
    }
    
    public boolean equals(GoofBasics g) {
        
        if (g.id != g.id) {
            return false;
        }
        if (!(g.name.equals(this.name))) {
            return false;
        }
        return true;
    }
    
    public int addEmployee(Employee e){
        this.employeeList.add(e);
        return 1;
    }
    
    public int addProduct(Product p){
        this.productList.add(p);
        return 1;
    }
    
    
}
