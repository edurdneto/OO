/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class MyProgram {

    
    public static void main(String[] args) {
        // TODO code application logic here
        LibrarySearch l;
        l = new LibrarySearch();
        String input=null,output=null;
        int i = 1;
        try {
            File f = new File(args[0]);
            if(args.length==2){
                output=args[1];
                if (f.exists()) {
                    input=args[0];
                    readFile(input, l);
                }
            } else {
                if(args.length==1){
                    output=args[0];
                } 
            }
        } catch (RuntimeException e) {
            System.out.println("Exception "+e.getMessage());
        }
        
        System.out.println(output);
        FirstWindow gui=new FirstWindow(l,output);
        gui.setVisible(true);
        
        
    }
    
    private static void readFile(String fileName, LibrarySearch l) {
        Scanner catalog = null;
        String imput, callnumber, title, year, publisher, organization, author;
        int type;

        try {
            catalog = new Scanner(new FileInputStream(fileName));
            //write code to print info to the file in the format:
            //<ItemName> by <itemCreator> for <Price>
            if (catalog.hasNextLine()) {
                do {
                    imput = catalog.nextLine();
                    imput = imput.substring(7);
                    StringTokenizer title_token;

                    if (imput.equalsIgnoreCase("book")) {
                        type = 1;
                        imput = catalog.nextLine();
                        callnumber = imput.substring(13);
                        imput = catalog.nextLine();
                        author = imput.substring(10);
                        imput = catalog.nextLine();
                        title = imput.substring(8);
                        imput = catalog.nextLine();
                        publisher = imput.substring(12);
                        imput = catalog.nextLine();
                        year = imput.substring(7);
                        Book b = new Book(Integer.parseInt(callnumber), title, Integer.parseInt(year));
                        if (!publisher.equals(null)) {
                            b.setPublisher(publisher);
                        }
                        ArrayList<Author> list_authors = new ArrayList<>();
                        StringTokenizer token;
                        token = new StringTokenizer(author, ",");
                        while (token.hasMoreTokens()) {
                            Author a = new Author(token.nextToken());
                            list_authors.add(a);
                        }
                        b.setSetAuthor(list_authors);
                        l.addBook(b);
                    } else {
                        type = 2;
                        imput = catalog.nextLine();
                        callnumber = imput.substring(13);
                        imput = catalog.nextLine();
                        title = imput.substring(8);
                        imput = catalog.nextLine();
                        organization = imput.substring(15);
                        imput = catalog.nextLine();
                        year = imput.substring(7);
                        Journal j = new Journal(Integer.parseInt(callnumber), title, Integer.parseInt(year));
                        if (!organization.equals(null)) {
                            j.setOrganization(organization);
                        }
                        l.addJournal(j);
                    }

                    catalog.nextLine();
                } while (catalog.hasNextLine());
            }
            catalog.close();
        } catch (IOException ex) {
            Logger.getLogger(Reference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    

    

    

    /**
     * This method will be responsible to receive the input from the user and
     * call the method search from l
     *
     * @param l
     */
    

}
