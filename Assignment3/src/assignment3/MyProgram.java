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
        int i = 1;
        if (args[0] != null) {
            File f = new File(args[0]);
            if (f.exists()) {
                readFile(args[0], l);
            }
        }
        
        FirstWindow gui=new FirstWindow(l,args[1]);
        gui.setVisible(true);
        
        /*

        while (i == 1) {
            int type;
            Scanner scan = new Scanner(System.in);
            System.out.println("LibrarySearch");
            System.out.println("Type add, search or quit");

            StringTokenizer token;
            String operation = scan.nextLine();
            token = new StringTokenizer(operation);
            if (token.countTokens() == 1) {
                i = 1;
                operation = token.nextToken();
                if (operation.equalsIgnoreCase("Add")) {
                    type = 1;
                } else {
                    if (operation.equalsIgnoreCase("Search")) {
                        type = 2;
                    } else {
                        if (operation.equalsIgnoreCase("quit")) {
                            type = 3;
                        } else {
                            type = 10;
                        }
                    }
                }
            } else {
                type = 10;
            }

            switch (type) {
                case 1:
                    Add(l);
                    break;
                case 2:
                    search(l);
                    break;
                case 3:
                    writeFile(args[1], l);
                    i = 0;
                    break;
                default:
                    System.out.println("You typed an invalid command");
            }
        }*/
    }
    /*Based on the description so far, your implementation should
     include at least three classes: Book, Journal, and LibrarySearch. 
     The Book class should contain a call number, a set of authors, a title, a publisher, and a year. 
     The Journal class should contain a call number, a title, an organization, and a year. 
     For both book and journal objects, we should always have a call number, a title, and a year. 
     The other fields can be empty if not available. 
     In addition, a year should be a four digit number between 1000 and 9999 in order to reject some 
     irrelevant values.   The LibrarySearch class is the most challenging, since it needs to maintain two 
     ArrayLists for books and journals, search the lists sequentially for the matched references, and display
     the result on the screen. */

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
     * This method will be responsible to add a book in the LibrarySearch l. It
     * will receive from the user the input. Then it will create a book and call
     * the addBook from l.
     *
     * @param l LibrarySearch
     * @return integer
     */
     

    /**
     * This method will be responsible to add a journal in the LibrarySearch l.
     * It will receive from the user the input. Then it will create a journal j
     * and call the addJournal(j) from l.
     *
     * @param l
     * @return integer
     */
    

    /**
     * This method will be responsible to open the add Menu, and wait the user
     * choose what type of add will be executed: a book or a journal.
     *
     * @param l
     */
    

    /**
     * This method will be responsible to receive from the user the input for
     * authors.
     *
     * @param ArrayList<Author>setAuthors
     */
    

    /**
     * This method will be responsible to receive the input from the user and
     * call the method search from l
     *
     * @param l
     */
    

}
