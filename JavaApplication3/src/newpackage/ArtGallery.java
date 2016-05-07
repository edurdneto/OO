/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;

/**
 *
 * @author Harshavardhan
 * This concrete class implements methods specific to itself.
 * Since only ArtGalleries in the problem can buy paintings from other ArtGalleries,
 * and since PaintingGalleries cannot, we include that method here since it is 
 * specific to only ArtGalleries.
 * 
 * This class implements IAddSculpture because only the ArtGallery has sculptures.
 */
public class ArtGallery extends AbstractArtGallery implements IAddSculpture{
    
    private int availableFunds;
    
    public ArtGallery(int id, String name, int availableFunds) {
        this.id = id;
        this.name = name;
        this.availableFunds = availableFunds;
    }
    
    public int getId() {
        return id;
    }
    
    public int getAvailableFunds() {
        return availableFunds;
    }
    
    public void setAvailableFunds(int newFunds) {
        availableFunds = newFunds;
    }
    
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Painting> ggetPaintings() {
        return paintings;
    }
    
    public ArrayList<Sculpture> getSculptures() {
        return sculptures;
    }
     
    
    public void addSculpture(String fileName, Sculpture newSculpture) {
        storeSculpture(newSculpture);
        catalogItem(fileName, newSculpture.getName(), newSculpture.getSculptorName());
    }
    
    @Override
    public void listPaintings() {
        System.out.println("Paint List from "+ this.name+":");
        for(int i=0; i<paintings.size();i++) {
            System.out.println(paintings.get(i).getName());
        }
    }

    public void storeSculpture(Sculpture newSculpture) {
       //write codes to add sculpture object to ArrayList of sculptures 
        sculptures.add(newSculpture);
    }
    
    public void listSculptures() {
        //write codes to list sculptures in the gallery
        System.out.println("Sculpture List from "+ this.name+":");
        for(int i=0; i<sculptures.size();i++) {
            System.out.println(sculptures.get(i).getName());
        }
    }
    
    public void buy(ArtGallery source, String paintingName) {
        
        //write code to transfer painting from source to destination.
        //Do this by searching the painting in the source list. If found,
        //fetch its price and check if destination has funds available to buy
        //Do defensive programming as usual
        //once painting has been transferred from source to destination
        //decrement destination's funds and increment source's funds
        //by amount equal to the price of the painting
        
       
       //begin for loop 
            
            
        //find painting    
            Painting p=null;
            int i=0;
            ArrayList<Painting>paint_list=source.ggetPaintings();
            for(i=0; i<paint_list.size();i++) {
                if(paint_list.get(i).getName().equalsIgnoreCase(paintingName)){
                    p=paint_list.get(i);
                    break;
                }
            }
            if(p==null){
                System.out.println("Painting not found!");
            } else { 
                //painting found. now check if destination has funds to buy
                if(getAvailableFunds()>=p.getPrice()){
                    //destination has funds. 
                    //now transfer painting from source to destination
                    paintings.add(p);
                    source.paintings.remove(i);
                    setAvailableFunds(getAvailableFunds()-p.getPrice());
                    source.setAvailableFunds(source.getAvailableFunds()+p.getPrice());
                    System.out.println("Transation Complete!");
                    
                } else {
                    System.out.println("Funds not enought!");
                }
            }
            
                    
                    //destination has funds. 
                    //now transfer painting from source to destination 
                    
        //add painting to destination
             
        //remove from source gallery          
                    
        //decrement funds of destination by amount equal to price of painting
                    
        //increment funds of destination by amount equal to price of painting
                    
                    
                    //transaction complete
                
            
        
        
    }
    
}
