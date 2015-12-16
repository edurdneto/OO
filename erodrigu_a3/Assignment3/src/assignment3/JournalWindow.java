/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author eduardo
 */
public class JournalWindow extends JFrame implements ActionListener {
        public static final int WIDTH = 600;
        public static final int HEIGHT =600;
        LibrarySearch l;
        JTextField callNoJ=new JTextField(10);
        JTextField titleJ=new JTextField(10);
        JTextField organizationJ=new JTextField(10);
        JTextField yearJ=new JTextField(10);
        JTextArea mensageBox=new JTextArea(8,40);
    
        static String output;
    //PARA TESTAR
    
    JournalWindow(LibrarySearch l,String output){
        super("Library Search");
        this.output=output;
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));
        this.l=l;
        mensageBox.setEditable(false);
        callNoJ.setText(" ");
        titleJ.setText(" ");
        organizationJ.setText(" ");
        yearJ.setText(" ");
        mensageBox.setText(" ");
    
        
        JMenu com=new JMenu("Commands");
        JMenuItem addition=new JMenuItem("add");
        JMenuItem search=new JMenuItem("search");
        JMenuItem quit=new JMenuItem("quit");
        addition.addActionListener(this);
        search.addActionListener(this);
        quit.addActionListener(this);
        com.add(addition);
        com.add(search);
        com.add(quit);
        
        setLayout(new BorderLayout());
        
        /*QUADRADO DA ESQUERDA*/
        JPanel fields=new JPanel();
        fields.setLayout(new GridLayout(10,10));
        JLabel label1= new JLabel("Adding a reference");
        fields.add(label1);
        add(fields,BorderLayout.NORTH);
        
        //CENTER
        JPanel fieldsC=new JPanel();
        fieldsC.setLayout(new GridLayout(10,10));
        String[] types={"Book","Journal"};
        JComboBox type=new JComboBox(types);
        type.setSelectedIndex(1);
        type.addActionListener(this);
        fieldsC.add(type);
        callNoJ.setMaximumSize( callNoJ.getPreferredSize() );
        fieldsC.add(callNoJ);
        titleJ.setMaximumSize( titleJ.getPreferredSize() );
        fieldsC.add(titleJ);
        organizationJ.setMaximumSize( organizationJ.getPreferredSize() );
        fieldsC.add(organizationJ);
        yearJ.setMaximumSize( yearJ.getPreferredSize() );
        fieldsC.add(yearJ);
        add(fieldsC,BorderLayout.CENTER);
        //WEST
        JPanel fieldsW=new JPanel();
        fieldsW.setLayout(new GridLayout(10,10));
        JLabel typeLabel= new JLabel("type:");
        fieldsW.add(typeLabel);
        JLabel cNoLabel= new JLabel("Call No:");
        fieldsW.add(cNoLabel);
        JLabel titleLabel= new JLabel("Title:");
        fieldsW.add(titleLabel);
        JLabel OLabel= new JLabel("Organization:");
        fieldsW.add(OLabel);
        JLabel yLabel= new JLabel("Year:");
        fieldsW.add(yLabel);
        
        add(fieldsW,BorderLayout.WEST);
        
        
        /*QUadrado da esq*/
        JPanel buttonPanel=new JPanel();
        JLabel blank=new JLabel(" ");
        buttonPanel.setLayout(new GridLayout(10,20));
        JButton reset=new JButton("Reset");
        reset.addActionListener(this);
        JButton addRef=new JButton("Add");
        addRef.addActionListener(this);
        buttonPanel.add(reset);
        buttonPanel.add(blank);
        buttonPanel.add(addRef);
        
        add(buttonPanel,BorderLayout.EAST);
        
        JPanel m=new JPanel();
        JLabel mTitle=new JLabel("Messages");
        JScrollPane scroll=new JScrollPane(mensageBox);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        m.add(mTitle);
        m.add(scroll);
        add(m,BorderLayout.SOUTH);
        
        
        JMenuBar bar=new JMenuBar();
        bar.add(com);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button=e.getActionCommand();
        switch(button){
            case "comboBoxChanged":
                JComboBox combo=(JComboBox)e.getSource();
                if(((String)combo.getSelectedItem()).equals("Journal")){
                    dispose();
                    JournalWindow gui=new JournalWindow(l,output);
                    gui.setVisible(true);
                } else {
                    dispose();
                    AddWindow gui=new AddWindow(l,output);
                    gui.setVisible(true); 
                }
                break;
            
            case "add":
                dispose();
                AddWindow gui=new AddWindow(l,output);
                gui.setVisible(true);
                break;
                
            case "search":
                dispose();
                SearchWindow gui2=new SearchWindow(l,output);
                gui2.setVisible(true);
                
                break;
              
            case "Reset":    
                callNoJ.setText(" ");
                titleJ.setText(" ");
                organizationJ.setText(" ");
                yearJ.setText(" ");
                mensageBox.setText(" ");
                break;
            case "Add":
                boolean addJournal=true;
                int callNo=0,year=0;
                
                //CALL NO
                Scanner scan = null;
                scan = new Scanner(callNoJ.getText());
                try {
                    StringTokenizer token;
                    token = new StringTokenizer(callNoJ.getText());
                    if (token.countTokens() == 0) {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!Call No van not be empty!");
                        addJournal = false;
                    } else {
                        callNo = scan.nextInt();
                    }   
                } catch (InputMismatchException e2) {
                    mensageBox.setText("Error!Call No must be an integer!");
                    addJournal = false;
                }
                //TITLE
                StringTokenizer token;
                token = new StringTokenizer(titleJ.getText());
                if (token.countTokens() == 0) {
                    mensageBox.setText(mensageBox.getText()+"\n"+"Error!You must print the title!");
                    addJournal=false;
                }
                //YEAR
                Scanner scanY = new Scanner(yearJ.getText());

                try {
                    StringTokenizer token2;
                    token2 = new StringTokenizer(yearJ.getText());
                    if (token2.countTokens() == 0) {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!Year can not be empty!");
                        addJournal = false;
                    } else {
                        year = scanY.nextInt();
                    }   
                } catch (InputMismatchException e2) {
                    mensageBox.setText("Error!Year must be an integer!");
                    addJournal = false;
                }
                
                if (year!=0) {
                    if (year >= 1000 && year <= 9999) {

                    } else {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!You typed an invalid year!");
                        addJournal = false;
                    }
                } else {
                    mensageBox.setText(mensageBox.getText() + "\n" + "Error!You typed an invalid year!");
                    addJournal = false;
                } 
                //publisher
                boolean organization_bool=false;
                token = new StringTokenizer(organizationJ.getText());
                if (token.countTokens() != 0) {
                    organization_bool = true;
                } else {
                    organization_bool = false;
                }
                
                //authors
                if(addJournal){
                    Journal j = new Journal(callNo, titleJ.getText(), year);
                    if(organization_bool){
                        j.setOrganization(organizationJ.getText());
                    }
                    mensageBox.setText("Journal Added!");
                    callNoJ.setText(" ");
                    titleJ.setText(" ");
                    organizationJ.setText(" ");
                    yearJ.setText(" ");
                    l.addJournal(j);
                }
                break;
                
            case "quit":
                this.writeFile(l);
                System.exit(0);
            break;
        }
    }
    
    private static void writeFile(LibrarySearch LS) {
        PrintWriter catalog;
        try {
            catalog = new PrintWriter(new BufferedWriter(new FileWriter(output, false)));

            //write code to print info to the file in the format:
            //<ItemName> by <itemCreator> for <Price>
            ArrayList<Reference> list;
            list = LS.getReferenceList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Book) {
                    Book b = (Book) list.get(i);
                    catalog.println("type = book");
                    catalog.println("callnumber = " + b.getCallNumber());
                    catalog.print("authors = ");
                    ArrayList<Author> a;
                    a = b.getSetAuthor();
                    for (int j = 0; j < a.size() - 1; j++) {
                        catalog.print(a.get(j).getName() + ",");
                    }
                    if (a.size() > 0) {
                        catalog.print(a.get(a.size() - 1).getName());
                    }
                    catalog.println("\ntitle = " + b.getTitle());
                    catalog.println("publisher = " + b.getPublisher());
                    catalog.println("year = " + b.getYear());
                } else {
                    Journal j = (Journal) list.get(i);
                    catalog.println("type = journal");
                    catalog.println("callnumber = " + j.getCallNumber());
                    catalog.println("title = " + j.getTitle());
                    catalog.println("organization = " + j.getOrganization());
                    catalog.println("year = " + j.getYear());
                }
                catalog.println();
            }

            catalog.close();
        } catch (IOException ex) {
            Logger.getLogger(Reference.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
