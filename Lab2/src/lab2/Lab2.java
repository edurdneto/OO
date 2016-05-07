/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<GoofBasics>gb_list=new ArrayList<>();
        GoofBasics store1=new GoofBasics(1,"Sinister Road");
        GoofBasics store2=new GoofBasics(2,"Sparrow Road");
        GoofBasics store3=new GoofBasics(3,"Goblin Road");
        
        gb_list.add(store1);
        gb_list.add(store2);
        gb_list.add(store3);
        
        int type=0;
        while(type!=4){
            System.out.println("Welcome to GoofBasics!");
            System.out.println("Select a supermarket or press 4 to exit:");
            for(int j=0;j<gb_list.size();j++){
                System.out.println(gb_list.get(j).getId()+"."+gb_list.get(j).getName());
            }
            Scanner scan=new Scanner(System.in);
            if(scan.hasNextInt()){
                type=scan.nextInt();
            } else {
                type=5;
            }
            if(type==1||type==2||type==3){
                Store(gb_list.get(type-1));
            } else {
                if(type==4){
                    System.out.println("Have a good day!");
                } else {
                    System.out.println("You typed an invalid number");
                }
            }
             
        }
    }

    private static void Store(GoofBasics store) {
        int type=0,i=0,rem;
        String name;
        int id;
                    
        while(type!=7){
            System.out.println(store.getName()+" Store");
            System.out.println("Select the operation or press 7 to exit:");
            System.out.println("1.List Prodructs");
            System.out.println("2.Add Product");
            System.out.println("3.Remove Product");
            System.out.println("4.List Employees");
            System.out.println("5.Add Employee");
            System.out.println("6.Remove Employee");
            
            Scanner scan=new Scanner(System.in);
            if(scan.hasNextInt()){
                type=scan.nextInt();
            } else {
                type=8;
            }
            
            switch(type){
                case 1:
                    System.out.println(store.toStringProductList());
                break;
                case 2:
                    System.out.println("Type the product's name:");
                    Scanner scan_fields=new Scanner(System.in);
                    name=scan_fields.nextLine();
                    System.out.println("Type the product's id(non negative number)");
                    if(scan.hasNextInt()){
                        id=scan.nextInt();
                    } else {
                        System.out.println("Thats not a valid input");
                        break;
                    }
                    if(id>=0){
                        boolean duplicate=false;
                        i=0;
                        while(i<store.productList.size()){
                            if(store.productList.get(i).getId()==id){
                                System.out.println("Error! Duplicated Id!");
                                duplicate=true;
                                break;
                            }
                            i++;
                        }
                        if(duplicate==false){
                            Product p=new Product(id,name);
                            store.addProduct(p);
                            System.out.println("Product has been added!");
                        }
                    } else {
                        System.out.println("Invalid Id");
                    }
                    
                break;
                case 3:
                    //Scanner scan3=new Scanner(System.in);
                    System.out.println("Type the product's id");
                    if(scan.hasNextInt()){
                        id=scan.nextInt();
                    } else {
                        System.out.println("Thats not a valid input");
                        break;
                    }
                    rem=-1;
                    i=0;
                    while(i<store.productList.size()){
                        if(store.productList.get(i).getId()==id){
                            store.productList.remove(i);
                            System.out.println("Product has been removed!");
                            rem=1;
                            break;
                        }
                        i++;
                    }
                    if(rem==-1)System.out.println("Product not found!");
                break;
                case 4:
                    System.out.println("Type the Employee's name:");
                    Scanner scan4=new Scanner(System.in);
                    name=scan4.nextLine();
                    System.out.println("Type the Employee's id(non negative number)");
                    if(scan.hasNextInt()){
                        id=scan.nextInt();
                    } else {
                        System.out.println("Thats not a valid input");
                        break;
                    }
                    if(id>=0){
                        boolean duplicate=false;
                        i=0;
                        while(i<store.employeeList.size()){
                            if(store.employeeList.get(i).getId()==id){
                                System.out.println("Error! Duplicated Id!");
                                duplicate=true;
                                break;
                            }
                            i++;
                        }
                        if(duplicate==false){
                            Employee e=new Employee(id,name);
                            store.addEmployee(e);
                            System.out.println("Employee has been added!");
                        }
                    } else {
                        System.out.println("Invalid Id");
                    }
                break;
                case 5:
                    System.out.println(store.toStringEmployeeList());
                break;
                case 6:
                    System.out.println("Type the Employee's id");
                    if(scan.hasNextInt()){
                        id=scan.nextInt();
                    } else {
                        System.out.println("Thats not a valid input");
                        break;
                    }
                    rem=-1;
                    i=0;
                    while(i<store.employeeList.size()){
                        if(store.employeeList.get(i).getId()==id){
                            store.employeeList.remove(i);
                            System.out.println("Employee has been removed!");
                            rem=1;
                            break;
                        }
                        i++;
                    }
                    if(rem==-1)System.out.println("Employee not found!");
                break;
                case 7:
                break;
            }
             
        }
    }
    
}
