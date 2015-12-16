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
import java.util.NoSuchElementException;
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
import javax.swing.SwingConstants;

/**
 *
 * @author eduardo
 */
public class AddWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    JTextField callNoB = new JTextField(10);
    JTextField authorB = new JTextField(10);
    JTextField titleB = new JTextField(10);
    JTextField publisherB = new JTextField(10);
    JTextField yearB = new JTextField(10);
    JTextArea mensageBox = new JTextArea(8, 40);
    LibrarySearch l;
    static String output;
//PARA TESTAR

    AddWindow(LibrarySearch l, String output) {
        super("Library Search");
        this.output = output;
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
        this.l = l;
        mensageBox.setEditable(false);
        callNoB.setText(" ");
        authorB.setText(" ");
        titleB.setText(" ");
        publisherB.setText(" ");
        yearB.setText(" ");
        mensageBox.setText(" ");
        JMenu com = new JMenu("Commands");
        JMenuItem addition = new JMenuItem("add");
        JMenuItem search = new JMenuItem("search");
        JMenuItem quit = new JMenuItem("quit");
        addition.addActionListener(this);
        search.addActionListener(this);
        quit.addActionListener(this);
        com.add(addition);
        com.add(search);
        com.add(quit);

        setLayout(new BorderLayout());

        /*QUADRADO DA ESQUERDA*/
        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(10, 10));
        JLabel label1 = new JLabel("Adding a reference");
        fields.add(label1);
        add(fields, BorderLayout.NORTH);

        //CENTER
        JPanel fieldsC = new JPanel();
        fieldsC.setLayout(new GridLayout(10, 10));
        String[] types = {"Book", "Journal"};
        JComboBox type = new JComboBox(types);
        type.setSelectedIndex(0);
        type.addActionListener(this);
        fieldsC.add(type);
        //JTextField tcallNo=new JTextField(0);
        this.callNoB.setMaximumSize(this.callNoB.getPreferredSize());
        fieldsC.add(callNoB);
        this.authorB.setMaximumSize(this.authorB.getPreferredSize());
        fieldsC.add(authorB);
        titleB.setMaximumSize(titleB.getPreferredSize());
        fieldsC.add(titleB);
        publisherB.setMaximumSize(publisherB.getPreferredSize());
        fieldsC.add(publisherB);
        yearB.setMaximumSize(yearB.getPreferredSize());
        fieldsC.add(yearB);
        add(fieldsC, BorderLayout.CENTER);
        //WEST
        JPanel fieldsW = new JPanel();
        fieldsW.setLayout(new GridLayout(10, 10));
        JLabel typeLabel = new JLabel("type:");
        fieldsW.add(typeLabel);
        JLabel cNoLabel = new JLabel("Call No:");
        fieldsW.add(cNoLabel);
        JLabel authorsLabel = new JLabel("Authors:");
        fieldsW.add(authorsLabel);
        JLabel titleLabel = new JLabel("Title:");
        fieldsW.add(titleLabel);
        JLabel PLabel = new JLabel("Publisher:");
        fieldsW.add(PLabel);
        JLabel yLabel = new JLabel("Year:");
        fieldsW.add(yLabel);

        add(fieldsW, BorderLayout.WEST);

        /*QUadrado da esq*/
        JPanel buttonPanel = new JPanel();
        JLabel blank = new JLabel(" ");
        buttonPanel.setLayout(new GridLayout(10, 20));
        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        JButton addRef = new JButton("Add");
        addRef.addActionListener(this);
        buttonPanel.add(reset);
        buttonPanel.add(blank);
        buttonPanel.add(addRef);

        add(buttonPanel, BorderLayout.EAST);

        JPanel m = new JPanel();
        JLabel mTitle = new JLabel("Messages");
        JScrollPane scroll = new JScrollPane(mensageBox);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        m.add(mTitle);
        m.add(scroll);
        add(m, BorderLayout.SOUTH);

        JMenuBar bar = new JMenuBar();
        bar.add(com);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        /*JComboBox combo=(JComboBox)e.getSource();
         if(((String)combo.getSelectedItem()).equals("Journal")){
         dispose();
         JournalWindow gui=new JournalWindow();
         gui.setVisible(true);
         }*/
        switch (button) {
            case "comboBoxChanged":
                JComboBox combo = (JComboBox) e.getSource();
                if (((String) combo.getSelectedItem()).equals("Journal")) {
                    dispose();
                    JournalWindow gui = new JournalWindow(l, output);
                    gui.setVisible(true);
                } else {
                    dispose();
                    AddWindow gui = new AddWindow(l, output);
                    gui.setVisible(true);
                }
                break;

            case "add":
                dispose();
                AddWindow gui = new AddWindow(l, output);
                gui.setVisible(true);
                break;

            case "search":
                dispose();
                SearchWindow gui2 = new SearchWindow(l, output);
                gui2.setVisible(true);
                break;

            case "Reset":
                callNoB.setText(" ");
                authorB.setText(" ");
                titleB.setText(" ");
                publisherB.setText(" ");
                yearB.setText(" ");

                break;
            case "Add":
                boolean addBook = true;
                int callNo = 0;
                int year = 0;

                //CALL NO
                Scanner scan = null;
                scan = new Scanner(callNoB.getText());
                try {
                    StringTokenizer token;
                    token = new StringTokenizer(callNoB.getText());
                    if (token.countTokens() == 0) {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!Call No van not be empty!");
                        addBook = false;
                    } else {
                        callNo = scan.nextInt();
                    }   
                } catch (InputMismatchException e2) {
                    mensageBox.setText("Error!Call No must be an integer!");
                    addBook = false;
                }

                //TITLE
                StringTokenizer token;
                token = new StringTokenizer(titleB.getText());
                if (token.countTokens() == 0) {
                    mensageBox.setText(mensageBox.getText() + "\n" + "Error!You must print the title!");
                    addBook = false;
                }
                //YEAR
                
                
                Scanner scanY = new Scanner(yearB.getText());
                
                try {
                    StringTokenizer token2;
                    token2 = new StringTokenizer(yearB.getText());
                    if (token2.countTokens() == 0) {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!Year can not be empty!");
                        addBook = false;
                    } else {
                        year = scanY.nextInt();
                    }   
                } catch (InputMismatchException e2) {
                    mensageBox.setText("Error!Year must be an integer!");
                    addBook = false;
                }
                
                if (year!=0) {
                    if (year >= 1000 && year <= 9999) {

                    } else {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!You typed an invalid year!");
                        addBook = false;
                    }
                } else {
                    mensageBox.setText(mensageBox.getText() + "\n" + "Error!You typed an invalid year!");
                    addBook = false;
                }
                //publisher
                boolean publisher_bool = false;
                token = new StringTokenizer(publisherB.getText());
                if (token.countTokens() != 0) {
                    publisher_bool = true;
                } else {
                    publisher_bool = false;
                }

                //authors
                ArrayList<Author> setAuthors = new ArrayList<>();
                boolean author_bool = false;
                token = new StringTokenizer(authorB.getText());
                if (token.countTokens() != 0) {
                    author_bool = true;
                } else {
                    author_bool = false;
                }
                if (author_bool) {
                    addAuthors(setAuthors, authorB.getText());
                }
                if (addBook) {
                    Book b = new Book(callNo, titleB.getText(), year);
                    if (publisher_bool) {
                        b.setPublisher(publisherB.getText());
                    }
                    if (author_bool) {
                        b.setSetAuthor(setAuthors);
                    }
                    mensageBox.setText("Book Added!");
                    callNoB.setText(" ");
                    authorB.setText(" ");
                    titleB.setText(" ");
                    publisherB.setText(" ");
                    yearB.setText(" ");
                    l.addBook(b);
                }

                break;

            case "quit":
                this.writeFile(l);
                System.exit(0);
                break;
        }
    }

    /**
     * This method will be responsible to write in a txt file.
     *
     * @param LibrarySearch LS
     */
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
    
    /**
     * This method will be responsible to receive from the user the input for
     * authors.
     *
     * @param ArrayList<Author>setAuthors
     * @param String authors
     */
    
    private static void addAuthors(ArrayList<Author> setAuthors, String authors) {
        int i = 1, j = 0;

        StringTokenizer token;
        token = new StringTokenizer(authors, ",");

        while (token.hasMoreTokens()) {
            Author a = new Author(token.nextToken());
            setAuthors.add(a);
        }
    }
}
