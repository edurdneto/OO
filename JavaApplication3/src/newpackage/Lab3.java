/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Harshavardhan
 */
public class Lab3 {
    
    public static void main(String args[]) {
        
        ArrayList<ArtGallery> artGalleries = new ArrayList();
        ArrayList<PaintingGallery> paintingGalleries = new ArrayList();
        
       
        //Begin by creating two ArrayLists. 
        //One will hold two ArtGallery objects.
        //Assign them IDs, Names and Funds of 0,NY,2000
        //and 1,Toronto,5000 respectively.
        AbstractArtGallery a1=new ArtGallery(0, "NY", 2000);
        AbstractArtGallery a2=new ArtGallery(1, "Toronto", 5000);
        artGalleries.add((ArtGallery) a1);
        artGalleries.add((ArtGallery) a2);
        
         //The second ArrayList will hold two PaintingGallery objects.
        //Assign them IDs and Names of 2, Toronto
        //and 3, Seattle respectively.
        AbstractArtGallery p1=new PaintingGallery(2, "Toronto");
        AbstractArtGallery p2=new PaintingGallery(3, "Seattle");
        paintingGalleries.add((PaintingGallery) p1);
        paintingGalleries.add((PaintingGallery) p2);
        
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int galleryChoice = 0;
        int opChoice = 0;
        
        while(galleryChoice != 4) {
            
            opChoice = 0;
            
            //print first menu
            System.out.println("\nSelect an art gallery supermarket or press 4 to exit: "
                    + "\n0. NY" 
                    + "\n1. Toronto"
                    + "\n2. Vancouver"
                    + "\n3. Seattle");
            
            try {
                galleryChoice = Integer.parseInt(scan.readLine());
                
                //exit if user selects 4
                if(galleryChoice == 4) {
                    System.exit(0);
                }
                
                //print message if invalid user choice
                if(galleryChoice<0||galleryChoice>4){
                    opChoice=7;
                    System.out.println("Invalid Input!");
                }
                
                while(opChoice != 7) {
                    
                    //show second menu
                    
                    System.out.println("\nSelect an operation: "
                        + "\n1. List Paintings"
                        + "\n2. Add Paintings");
                    if(galleryChoice==0||galleryChoice==1){
                        System.out.println("3. List Sculptures"        //show this only for ArtGalleries, not PaintingGalleries 
                        + "\n4. Add Sculptures"         //show this only for ArtGalleries, not PaintingGalleries 
                        + "\n5. Buy Paintings");          //show this only for ArtGalleries, not PaintingGalleries 
                    }
                    System.out.println("6. Back to gallery selection");

                    opChoice = Integer.parseInt(scan.readLine());
                    String fileName=null;
            
                    switch(opChoice) {
                        case 1: 
                            //list paintings from selected gallery
                            //for example 
                            if(galleryChoice==0||galleryChoice==1){
                                artGalleries.get(galleryChoice).listPaintings();
                            } else {
                                paintingGalleries.get(galleryChoice-2).listPaintings();
                            }
                            break;

                        case 2: 
                            //Scan painter's name, painting's name and price.
                            fileName="painting.txt";
                            int i=1;
                            String painterName=null;
                            String paintName=null;
                            int price=0;
                                
                            while(i==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the painter's name:");
                                painterName = imput.nextLine();
                                StringTokenizer token=new StringTokenizer(painterName);
                                if(token.countTokens()!=0){
                                    i=0;
                                }
                            }
                            i=1;
                            while(i==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the painting's name:");
                                paintName = imput.nextLine();
                                StringTokenizer token=new StringTokenizer(paintName);
                                if(token.countTokens()!=0){
                                    i=0;
                                }
                            }
                            i=1;
                            while(i==1){
                                Scanner imput=new Scanner(System.in); 
                                System.out.println("Type the price:");
                                if(imput.hasNextInt()){
                                    price=imput.nextInt();
                                    i=0;
                                } else {
                                    System.out.println("You typed an invalid number");
                                }
                            }
                            Painting p=new Painting(painterName, paintName, price);
                            //add the painting to selected gallery
                            if(galleryChoice==0||galleryChoice==1){
                                artGalleries.get(galleryChoice).addPainting(fileName, p);
                            } else {
                                paintingGalleries.get(galleryChoice-2).addPainting(fileName, p);
                            }
                            break;

                        case 3: 
                            if(galleryChoice!=0&&galleryChoice!=1){
                                System.out.println("Wrong Imput!");
                                break;
                            }
                            artGalleries.get(galleryChoice).listSculptures();
                            break;
                            
                        case 4:
                            fileName="sculpture.txt";
                            if(galleryChoice!=0&&galleryChoice!=1){
                                System.out.println("Wrong Imput!");
                                break;
                            }
                            int j=1;
                            String sculptorName=null;
                            String sculptureName=null;
                            
                                
                            while(j==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the sculptor's name:");
                                sculptorName = imput.nextLine();
                                StringTokenizer token=new StringTokenizer(sculptorName);
                                if(token.countTokens()!=0){
                                    j=0;
                                }
                            }
                            j=1;
                            while(j==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the sculpture's name:");
                                sculptureName = imput.nextLine();
                                StringTokenizer token=new StringTokenizer(sculptureName);
                                if(token.countTokens()!=0){
                                    j=0;
                                }
                            }
                            Sculpture s=new Sculpture(sculptureName, sculptorName);
                            artGalleries.get(galleryChoice).addSculpture(fileName, s);
                            break;
                            
                        case 5: 
                            if(galleryChoice!=0&&galleryChoice!=1){
                                System.out.println("Wrong Imput!");
                                break;
                            }
                            //This case is for buying paintings from another ArtGallery
                            
                            //scan source gallery's id (refer to IDs in the menu)
                            int loop=1;
                            int gallery_id=-1;
                            String pName=null;
                            
                                
                            while(loop==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the gallery id:");
                                if(imput.hasNextInt()){
                                    gallery_id=imput.nextInt();
                                    if(gallery_id==0||gallery_id==1)loop=0;
                                    else System.out.println("Galley not found!");
                                } else {
                                    System.out.println("You typed an invalid number");
                                } 
                            }
                            loop=1;
                            while(loop==1){
                                Scanner imput = new Scanner(System.in);
                                System.out.println("Type the painting's name:");
                                pName = imput.nextLine();
                                StringTokenizer token=new StringTokenizer(pName);
                                if(token.countTokens()!=0){
                                    loop=0;
                                }
                            }
                            //scan painting name
                            if(gallery_id!=galleryChoice){
                                artGalleries.get(galleryChoice).buy(artGalleries.get(gallery_id), pName);   
                            } else {
                                System.out.println("You canot buy from itself!");
                            }
                            //execute buy method in the artGallery.
                            //params to buy method are source ArtGallery Object and painting name
                            
                             break;
                            
                        case 6:
                            opChoice=7;
                            break;
                            
                        default:
                            System.out.println("Invalid Input!");
                            opChoice=9;
                            break;

                    }

                }
            
            } catch (Exception ex) {
                
            }
            
        }
    }
    
}
