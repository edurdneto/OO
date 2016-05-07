/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author eduardo
 */
public class main {

    /**
     * @param args the command line arguments
     * @return 
     */
    public static String inputString(){
        String input;
        System.out.println("Type a string:");
        Scanner scan=new Scanner(System.in);
        input=scan.nextLine();
        return input;
    }
    
    public static void PrintString(String input){
        System.out.println("The string is:"+input+"\n");
    }
    
    public static String ReverseString(String input){
        int i=input.length();
        String rev=new StringBuilder(input).reverse().toString();
        System.out.println("The reverse string is:"+rev+"\n");
        return rev;
    }
    
    public static void countSpaces(String input){
        int count=0,i=0;
        while(i<input.length()){
            if(' '==input.charAt(i)){
                count++;
            }
            i++;
             
        }
        System.out.println("Numer of spaces:"+count+"\n");
        
    }
    
    public static void numberString(String input){
        int i=0;
        while(i<input.length()){
            if(Character.isDigit(input.charAt(i))){
                System.out.println("Has the number:"+input.charAt(i));
            };
            i++;
        }
    }
    
    public static void countVowels(String input){
        int count=0,i=0;
        input=input.toLowerCase();
        while(i<input.length()){
            if(input.charAt(i)=='a'||input.charAt(i)=='e'||input.charAt(i)=='i'||input.charAt(i)=='o'||input.charAt(i)=='u'){
                count++;
            }
            i++;
        }
        System.out.println("Number of Vowels:"+count+"\n");
    }
    public static void countCon(String input){
        int count=0,i=0;
        while(i<input.length()){
            input=input.toLowerCase();
            if(Character.isLetter(input.charAt(i))&&input.charAt(i)!='a'&&input.charAt(i)!='e'&&input.charAt(i)!='i'&&input.charAt(i)!='o'&&input.charAt(i)!='u'){
                count++;
            }
            i++;
        }
        System.out.println("Number of consoants:"+count+"\n");
    }
    
    public static void menu () {
        int i=1;
        String input=null;
        StringTokenizer token;
        while(i!=0){
            
            System.out.println("1.Input String");
            System.out.println("2.Print String");
            System.out.println("3.Reverse the String");
            System.out.println("4.Tokenize String");
            System.out.println("5.Count spaces in the string");
            System.out.println("6.Check for a number in the string");
            System.out.println("7.Count Vowels");
            System.out.println("8.Count consoants");
            System.out.println("9.Exit Program");
            Scanner scan=new Scanner(System.in);
            
            int type;
            //String tempType=scan.next();
            /*if(Character.isDigit(tempType.charAt(0))){
                type=Character.getNumericValue(tempType.charAt(0));
            }
            else {
                type=10;
            }*/
            if(scan.hasNextInt()){
                type=scan.nextInt();
            } else {
                type=10;
            }
            switch (type) {
                case 1:
                    input=inputString();
                    break;
                case 2:
                    if(input!=null){
                        PrintString(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 3:
                    if(input!=null){
                        input=ReverseString(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 4:
                    if(input!=null){
                        token=new StringTokenizer(input);
                        while(token.hasMoreTokens()){
                            System.out.println(token.nextToken());
                        };
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 5:
                    if(input!=null){
                        countSpaces(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 6:
                    if(input!=null){
                        numberString(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 7:
                    if(input!=null){
                        countVowels(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 8:
                    if(input!=null){
                        countCon(input);
                    } else {
                        System.out.println("No String has been typed");
                    }
                    break;
                case 9:
                    i=0;
                    break;
                default:
                    System.out.println("Invalid Number\n");
                    break;
            }
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
        
    }
    
}
