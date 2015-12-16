/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author eduardo
 */
public class LibrarySearch {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Reference> referenceList;
    private final Map<String,ArrayList<Integer>>hmap=new HashMap<>();
    
    public LibrarySearch() {
        referenceList=new ArrayList<>();
    }
    
    public ArrayList<Reference> getReferenceList(){
        return referenceList;
    }
    
    public void setReferenceList(ArrayList<Reference> referenceList) {
        this.referenceList = referenceList;
    }
    
    public Map<String, ArrayList<Integer>> getHashMapList(){
        return hmap;
    }
    
    
    /**
     * This method will be responsible to add the book b in the referenceList.
     * @param b Book
     * @return integer
     */
    public int addBook(Book b){
        int i=0;
        boolean duplicate=false;
        while(i<referenceList.size()){
            duplicate=referenceList.get(i).equals(b);
            i++;
        }
        if(duplicate){
            System.out.println("Duplicate book!");
            return 0;
        } else {
            referenceList.add(b);
            String title=b.getTitle();
            StringTokenizer title_token;
            title_token=new StringTokenizer(title," ");
            while(title_token.hasMoreTokens()){
                String key=title_token.nextToken().toLowerCase();
                Boolean duplicate_key=false;
                if(hmap.containsKey(key)){
                    ArrayList<Integer> list_int=hmap.get(key);
                    for(int j=0;j<list_int.size();j++){
                        if(list_int.get(j)==referenceList.size()-1){
                            duplicate_key=true;
                        }
                    }
                    if(!duplicate_key){
                        list_int.add(referenceList.size()-1);
                        hmap.put(key, list_int);
                    }
                } else {
                    ArrayList<Integer> list_int=new ArrayList<>();
                    list_int.add(referenceList.size()-1);
                    hmap.put(key, list_int);
                }
            }
            return 1;
        }
    }
    
    /**
     * This method will be responsible to add the Journal j in the referencelList.
     *@param j Journal to be added
     *@return integer
     */
    public int addJournal(Journal j){
        int i=0;
        boolean duplicate=false;
        while(i<referenceList.size()){
            duplicate=referenceList.get(i).equals(j);
            i++;
        }
        if(duplicate){
            System.out.println("Duplicate journal!");
            return 0;
        } else {    
            referenceList.add(j);
            String title=j.getTitle();
            StringTokenizer title_token;
            title_token=new StringTokenizer(title," ");
            while(title_token.hasMoreTokens()){
                String key=title_token.nextToken().toLowerCase();
                Boolean duplicate_key=false;
                if(hmap.containsKey(key)){
                    ArrayList<Integer> list_int=hmap.get(key);
                    for(int k=0;k<list_int.size();k++){
                        if(list_int.get(k)==referenceList.size()-1){
                            duplicate_key=true;
                        }
                    }
                    if(!duplicate_key){
                        list_int.add(referenceList.size()-1);
                        hmap.put(key, list_int);
                    }
                } else {
                    ArrayList<Integer> list_int=new ArrayList<>();
                    list_int.add(referenceList.size()-1);
                    hmap.put(key, list_int);
                }
            }
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return "LibrarySearch{" + "Reference=" + this.referenceList+ '}';
    }
    
    /**
     * This method will be responsible search a reference in the referenceList.
     * @param callNumber the callNumber to be searched
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void search(int callNumber, int startPeriod, int endPeriod,int pos) {
        ArrayList<Reference>reference_list;
        reference_list=this.getReferenceList();
        for(int i=0;i<reference_list.size();i++){
            Reference b=reference_list.get(i);
            if(b.getCallNumber()==callNumber){
                if(pos==-2){
                    if(b.getYear()==startPeriod){
                        b.toString();
                        System.out.println(b.toString());
                    }
                } else {
                    if(pos!=-1){
                        if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                            System.out.println(b.toString());
                        }
                    } else {
                        System.out.println(b.toString());
                    }
                }
            }
        }
    
   }
    
    /**
     * This method will be responsible search a reference in the referenceList.
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void search(int startPeriod, int endPeriod,int pos) {
        ArrayList<Reference>reference_list;
        reference_list=this.getReferenceList();
        for(int i=0;i<reference_list.size();i++){
            Reference b=reference_list.get(i);
            if(pos==-2){
                if(b.getYear()==startPeriod){
                    b.toString();
                    System.out.println(b.toString());
                }
            } else {
                if(pos!=-1){
                    if(b.getYear()>=startPeriod&&b.getYear()<=endPeriod){
                        System.out.println(b.toString());
                    }
                } else {
                    System.out.println(b.toString());
                }
            }
        }
    }
    
    /**
     * This method will be responsible search a reference in the referenceList.
     * @param callNumber the callNumber to be searched
     * @param title the title to be searched using the hash map
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void search2(int callNumber, String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Reference>reference_list;
        reference_list=this.getReferenceList();
        StringTokenizer title_token=new StringTokenizer(title," ");
        String imput=title_token.nextToken().toLowerCase();
        if(hmap.containsKey(imput)){
            ArrayList<Integer>intersection=new ArrayList<Integer>(hmap.get(imput));
            for(int i=1;i<title_token.countTokens();i++){
                ArrayList<Integer> list1 = new ArrayList<Integer>(hmap.get(title_token.nextToken()));
                ArrayList<Integer> list2 = new ArrayList<Integer>(intersection);
                for(int j=0;j<list1.size();j++){
                    for(int k=0;k<list2.size();k++){
                        intersection.clear();
                        if(list1.get(j)==list2.get(k)){
                            intersection.add(j);
                        }
                    }
                }
            }
            for(int i=0;i<intersection.size();i++){
                if(referenceList.get(intersection.get(i)).getCallNumber()==callNumber){
                    if(pos==-2){
                        if(referenceList.get(intersection.get(i)).getYear()==startPeriod){
                            System.out.println(referenceList.get(intersection.get(i)).toString());
                        }
                    } else {
                        if(pos!=-1){
                            if(referenceList.get(intersection.get(i)).getYear()>=startPeriod&&referenceList.get(intersection.get(i)).getYear()<=endPeriod){
                                System.out.println(referenceList.get(intersection.get(i)).toString());
                            }
                        } else {
                            System.out.println(referenceList.get(intersection.get(i)).toString());
                        }
                    }
                }
            }
        }
    }
        
    /**
     * This method will be responsible search a reference in the referenceList.
     * @param title the title to be searched using the hash map
     * @param startPeriod the initial period to be checked 
     * @param endPeriod the end period to be checked
     * @param pos used to define if will be the period or just the year
     */
    public void search2(String title, int startPeriod, int endPeriod,int pos) {
        ArrayList<Reference>reference_list;
        reference_list=this.getReferenceList();
        StringTokenizer title_token=new StringTokenizer(title," ");
        String imput=title_token.nextToken().toLowerCase();
        if(hmap.containsKey(imput)){
            ArrayList<Integer>intersection=new ArrayList<Integer>(hmap.get(imput));
            for(int i=1;i<title_token.countTokens();i++){
                ArrayList<Integer> list1 = new ArrayList<Integer>(hmap.get(title_token.nextToken()));
                ArrayList<Integer> list2 = new ArrayList<Integer>(intersection);
                for(int j=0;j<list1.size();j++){
                    for(int k=0;k<list2.size();k++){
                        intersection.clear();
                        if(list1.get(j)==list2.get(k)){
                            intersection.add(j);
                        }
                    }
                }
            }
            for(int i=0;i<intersection.size();i++){
                if(pos==-2){
                    if(referenceList.get(intersection.get(i)).getYear()==startPeriod){
                        System.out.println(referenceList.get(intersection.get(i)).toString());
                    }
                } else {
                    if(pos!=-1){
                        if(referenceList.get(intersection.get(i)).getYear()>=startPeriod&&referenceList.get(intersection.get(i)).getYear()<=endPeriod){
                            System.out.println(referenceList.get(intersection.get(i)).toString());
                        }
                    } else {
                        System.out.println(referenceList.get(intersection.get(i)).toString());
                    }
                }
            }
        }
    }
}
