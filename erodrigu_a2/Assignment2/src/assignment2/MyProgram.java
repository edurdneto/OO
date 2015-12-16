/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

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
        int i=1;
        if(args[0]!=null){
            File f=new File(args[0]);
            if(f.exists()) readFile(args[0], l);
        }
        
        while(i==1){
            int type;
            Scanner scan=new Scanner(System.in);
            System.out.println("LibrarySearch");
            System.out.println("Type add, search or quit");
            
            StringTokenizer token;
            String operation=scan.nextLine();
            token=new StringTokenizer(operation);
            if(token.countTokens()==1){
                i=1;
                operation=token.nextToken();
                if(operation.equalsIgnoreCase("Add")){
                    type=1;
                } else {
                    if(operation.equalsIgnoreCase("Search")){
                        type=2;
                    } else {
                        if(operation.equalsIgnoreCase("quit")){
                            type=3;
                        } else {
                            type=10;
                        }
                    }
                }
            } else {
                type=10;
            }
            
            switch(type){
                case 1:
                    Add(l);
                    break;
                case 2:
                    search(l);
                    break;
                case 3:
                    writeFile(args[1],l);
                    i=0;
                    break; 
                default:
                    System.out.println("You typed an invalid command");
            }
        }
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
    
    
    private static void readFile(String fileName,LibrarySearch l){
        Scanner catalog=null;
        String imput,callnumber,title,year,publisher,organization,author;
        int type;
        
        try {
            catalog = new Scanner(new FileInputStream(fileName));
            //write code to print info to the file in the format:
            //<ItemName> by <itemCreator> for <Price>
            do{
                imput=catalog.nextLine();
                imput=imput.substring(7);
                StringTokenizer title_token;
      
                if(imput.equalsIgnoreCase("book")){
                    type=1;
                    imput=catalog.nextLine();
                    callnumber=imput.substring(13);
                    imput=catalog.nextLine();
                    author=imput.substring(10);
                    imput=catalog.nextLine();
                    title=imput.substring(8);
                    imput=catalog.nextLine();
                    publisher=imput.substring(12);
                    imput=catalog.nextLine();
                    year=imput.substring(7);
                    Book b=new Book(Integer.parseInt(callnumber),title,Integer.parseInt(year));
                    if(!publisher.equals(null)){
                        b.setPublisher(publisher);
                    }
                    ArrayList<Author> list_authors=new ArrayList<>();
                    StringTokenizer token;
                    token=new StringTokenizer(author,",");
                    while(token.hasMoreTokens()){
                        Author a=new Author(token.nextToken());
                        list_authors.add(a);
                    }
                    b.setSetAuthor(list_authors);
                    l.addBook(b);
                } else {
                    type=2;
                    imput=catalog.nextLine();
                    callnumber=imput.substring(13);
                    imput=catalog.nextLine();
                    title=imput.substring(8);
                    imput=catalog.nextLine();
                    organization=imput.substring(15);
                    imput=catalog.nextLine();
                    year=imput.substring(7);
                    Journal j=new Journal(Integer.parseInt(callnumber),title,Integer.parseInt(year));
                    if(!organization.equals(null)){
                        j.setOrganization(organization);
                    }
                    l.addJournal(j);
                }
               
                catalog.nextLine();
            } while(catalog.hasNextLine());
            catalog.close();
        } catch (IOException ex) {
            Logger.getLogger(Reference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void writeFile(String output,LibrarySearch LS){
        PrintWriter catalog;
        try {
            catalog = new PrintWriter(new BufferedWriter(new FileWriter(output, false)));
            
            //write code to print info to the file in the format:
            //<ItemName> by <itemCreator> for <Price>
            ArrayList<Reference> list;
            list=LS.getReferenceList();
            for(int i=0;i<list.size();i++){
                if (list.get(i) instanceof Book) {
                    Book b=(Book)list.get(i);
                    catalog.println("type = book");
                    catalog.println("callnumber = "+b.getCallNumber());
                    catalog.print("authors = ");
                    ArrayList<Author> a;
                    a=b.getSetAuthor();
                    for(int j=0;j<a.size()-1;j++){
                        catalog.print(a.get(j).getName()+",");
                    }
                    if(a.size()>0)catalog.print(a.get(a.size()-1).getName());
                    catalog.println("\ntitle = "+b.getTitle());
                    catalog.println("publisher = "+b.getPublisher());
                    catalog.println("year = "+b.getYear());
                } else {
                    Journal j=(Journal)list.get(i);
                    catalog.println("type = journal");
                    catalog.println("callnumber = "+j.getCallNumber());
                    catalog.println("title = "+j.getTitle());
                    catalog.println("organization = "+j.getOrganization());
                    catalog.println("year = "+j.getYear());
                }
                catalog.println();
            }
            
            catalog.close();
        } catch (IOException ex) {
            Logger.getLogger(Reference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**This method will be responsible to add a book in the LibrarySearch l.
     *It will receive from the user the input. Then it will create a book and call
     * the addBook from l.
     * @param l LibrarySearch
     * @return integer
     */
    private static int addBook(LibrarySearch l) {
  
        int callNumber=-1,i=1;
        String title=null;
        int year=0;
        String publisher=null;
        boolean publisher_bool=false;
        ArrayList<Author>setAuthors=new ArrayList<>();
        
        System.out.println("Adding a Book");
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
        
            System.out.println("Type the call number:");
            if(scan.hasNextInt()){
                callNumber=scan.nextInt();
                i=0;
            } else {
                System.out.println("You typed an invalid number");
            }
        }
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
            StringTokenizer token;
            System.out.println("Type the title:");
            title=scan.nextLine();
            token=new StringTokenizer(title);
            if(token.countTokens()!=0){
                i=0;
            } else {
                System.out.println("You must print the title!");
            }
        }
        
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
        
            System.out.println("Type the year(1000-9999)");
            if(scan.hasNextInt()){
                year=scan.nextInt();
                if(year>=1000&&year<=9999){
                    i=0;
                } else {
                    System.out.println("You typed an invalid year!");
                }
            } else {
                System.out.println("You typed an invalid number");
            }
        }
        
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
            StringTokenizer token;
            System.out.println("Type the publisher(not required):");
            publisher=scan.nextLine();
            token=new StringTokenizer(publisher);
            if(token.countTokens()!=0){
                publisher_bool=true;
            } else {
                publisher_bool=false;
            }
            i=0;
        }
        addAuthors(setAuthors);
            
        Book b=new Book(callNumber,title,year);
        b.setSetAuthor(setAuthors);
        if(publisher_bool)b.setPublisher(publisher);
        return l.addBook(b);
      
    }

    /**This method will be responsible to add a journal in the LibrarySearch l.
     *It will receive from the user the input. Then it will create a journal j and call
     * the addJournal(j) from l.
     * @param l
     * @return integer
     */
    private static int addJournal(LibrarySearch l) {
        int callNumber=-1,i=1;
        String title=null;
        int year=0;
        String organization=null;
        boolean organization_bool=false;
        
        System.out.println("Adding a Journal");
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
        
            System.out.println("Type the call number:");
            if(scan.hasNextInt()){
                callNumber=scan.nextInt();
                i=0;
            } else {
                System.out.println("You typed an invalid number");
            }
        }
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
            StringTokenizer token;
            System.out.println("Type the title:");
            title=scan.nextLine();
            token=new StringTokenizer(title);
            if(token.countTokens()!=0){
                i=0;
            } else {
                System.out.println("You must print the title!");
            }
        }
        
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
        
            System.out.println("Type the year");
            if(scan.hasNextInt()){
                year=scan.nextInt();
                if(year>=1000&&year<=9999){
                    i=0;
                } else {
                    System.out.println("You typed an invalid year!");
                }
            } else {
                System.out.println("You typed an invalid number");
            }
        }
        
        i=1;
        
        while(i==1){
            Scanner scan=new Scanner(System.in);
            StringTokenizer token;
            System.out.println("Type the organization(not required):");
            organization=scan.nextLine();
            token=new StringTokenizer(organization);
            if(token.countTokens()!=0){
                organization_bool=true;
            } else {
                organization_bool=false;
            }
            i=0;
        }
        Journal j=new Journal(callNumber,title,year);
        if(organization_bool)j.setOrganization(organization);
        return l.addJournal(j);
        
    }

    /**
     * This method will be responsible to open the add Menu, and wait the user choose
     * what type of add will be executed: a book or a journal.
     * @param l
     */
    private static void Add(LibrarySearch l) {
        int type,i=1,confirmation;
        while(i==1){
            Scanner scan=new Scanner(System.in);
            System.out.println("Type one of the 2 choise(1 or 2):");
            System.out.println("1.Book");
            System.out.println("2.Journal");
            
            if(scan.hasNextInt()){
                type=scan.nextInt();
            } else {
                type=3;
            }
            switch(type){
                case 1:
                    i=0;
                    confirmation=addBook(l);
                    if(confirmation==1){
                        System.out.println("The book has been added");
                    } else {
                        System.out.println("The book has not been added");
                    }  
                    break;
                case 2:
                    confirmation=addJournal(l);
                    if(confirmation==1){
                        System.out.println("The journal has been added");
                    } else {
                        System.out.println("The journal has not been added");
                    }
                    i=0;
                    break;
                default:
                    System.out.println("You typed an invalid number");
                    break;
            }
            
        }
    }
    
    /**
     *This method will be responsible to receive from the user the input 
     * for authors. 
     * @param ArrayList<Author>setAuthors 
     */
    private static void addAuthors(ArrayList<Author>setAuthors) {
        int i=1,j=0;
        String name;
        boolean name_bool=false;
        
        Scanner scan=new Scanner(System.in);
        String input;
        StringTokenizer token;
        System.out.println("Type the name of the authors separeted by ','(not required):");
        input=scan.nextLine();
        token=new StringTokenizer(input,",");
        
        while(token.hasMoreTokens()){
            Author a=new Author(token.nextToken());
            setAuthors.add(a);
        }
            
    }
    
    /**
     * This method will be responsible to receive the input from the user and call the method search
     * from l
     * @param l
     */

    private static void search(LibrarySearch l) {
        ArrayList<Book>booksFound;
        ArrayList<Journal>journalsFound;
        boolean bol_calNumber=false;
        boolean bol_title=false;
        boolean bol_startPeriod=false;
        boolean bol_endPeriod=false;
        int callNumber=0,startPeriod=0,endPeriod=0;
        String title;
        
        System.out.println("Search Request");
        
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Type the call number for search:");
        String callN;
        callN=scan.nextLine();
        if(!callN.isEmpty()){
           try {
               callNumber=Integer.parseInt(callN);
               bol_calNumber=true;
            } catch(NumberFormatException e) { 
                 bol_calNumber=false;
            }
        
        }
        StringTokenizer token;
        System.out.println("Type the title for search:");
        title=scan.nextLine();
        token=new StringTokenizer(title);
        if(token.countTokens()!=0){
            bol_title=true;
        }
          
        
        System.out.println("Type the period for search(year,-year,year- or year1-year2)");
        String input;
        input=scan.nextLine();
        
        int pos=-1;
        int i=0;
        if(input.length()>0){
            while(i<input.length()){
                if(input.charAt(i)=='-'){
                    pos=i;
                    i=input.length();
                   
                }
                i++;
            }
        }
        if(input.length()>0&&pos==-1)pos=-2;
        if(pos==0){
            bol_startPeriod=true;
            startPeriod=1000;
            token=new StringTokenizer(input,"-");
            try {
                    endPeriod=Integer.parseInt(token.nextToken());
                    
                    bol_endPeriod=true;
                } catch(NumberFormatException e) { 
                    bol_startPeriod=false;
                }
        } else {
            if(pos>0){
                token=new StringTokenizer(input,"-");
                try {
                    startPeriod=Integer.parseInt(token.nextToken());
                    bol_startPeriod=true;
                } catch(NumberFormatException e) { 
                    bol_startPeriod=false;
                  
                }
                if(bol_startPeriod){
                    if(pos<input.length()-1){
                        input=input.substring(pos);
                        try {
                            endPeriod=Integer.parseInt(input)*-1;
                            bol_endPeriod=true;
                        } catch(NumberFormatException e) { 
                            bol_startPeriod=false;
                            System.out.println("Invalid Period Format");
                        }
                    } else {
                        bol_endPeriod=true;
                        endPeriod=9999;
                    }
                }
            }
        }
        if(pos==-2){
            try {
                startPeriod=Integer.parseInt(input);
            } catch(NumberFormatException e) { 
              System.out.println("Invalid Period Format");
            }  
        }
        if(bol_calNumber&&bol_title){
            l.search2(callNumber,title,startPeriod,endPeriod,pos);
        }
        if(bol_calNumber&&!bol_title){
            l.search(callNumber,startPeriod,endPeriod,pos);
        }
        if(!bol_calNumber&&bol_title){
            l.search2(title,startPeriod,endPeriod,pos);
        }
        if(!bol_calNumber&&!bol_title){
            l.search(startPeriod,endPeriod,pos);
        }
        
     }
    
}
