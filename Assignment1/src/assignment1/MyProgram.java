/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
            l.searchBook(callNumber,title,startPeriod,endPeriod,pos);
            l.searchJournal(callNumber,title,startPeriod,endPeriod,pos);
            System.out.println("entrei aqui");
        }
        if(bol_calNumber&&!bol_title){
            l.searchBook(callNumber,startPeriod,endPeriod,pos);
            l.searchJournal(callNumber,startPeriod,endPeriod,pos);
        }
        if(!bol_calNumber&&bol_title){
            l.searchBook(title,startPeriod,endPeriod,pos);
            l.searchJournal(title,startPeriod,endPeriod,pos);
        }
        if(!bol_calNumber&&!bol_title){
            l.searchBook(startPeriod,endPeriod,pos);
            l.searchJournal(startPeriod,endPeriod,pos);
        }
        
     }
    
}
