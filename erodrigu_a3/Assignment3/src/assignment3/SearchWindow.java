/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import static assignment3.AddWindow.output;
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
public class SearchWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    //PARA TESTAR
    LibrarySearch l;
    static String output;
    JTextField callNoR = new JTextField(10);
    JTextField titleR = new JTextField(10);
    JTextField startY = new JTextField(10);
    JTextField endY = new JTextField(10);
    JTextArea mensageBox = new JTextArea(8, 40);

    SearchWindow(LibrarySearch l, String output) {
        super("Searching references");
        this.l = l;
        this.output = output;
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
        mensageBox.setEditable(false);
        callNoR.setText(" ");
        titleR.setText(" ");
        startY.setText(" ");
        endY.setText(" ");
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
        JLabel label1 = new JLabel("Searching references");
        fields.add(label1);
        add(fields, BorderLayout.NORTH);

        //CENTER
        JPanel fieldsC = new JPanel();
        fieldsC.setLayout(new GridLayout(10, 10));
        callNoR.setMaximumSize(callNoR.getPreferredSize());
        fieldsC.add(callNoR);
        titleR.setMaximumSize(titleR.getPreferredSize());
        fieldsC.add(titleR);
        startY.setMaximumSize(startY.getPreferredSize());
        fieldsC.add(startY);
        endY.setMaximumSize(endY.getPreferredSize());
        fieldsC.add(endY);
        add(fieldsC, BorderLayout.CENTER);
        //WEST
        JPanel fieldsW = new JPanel();
        fieldsW.setLayout(new GridLayout(10, 10));
        JLabel cNoLabel = new JLabel("Call No:");
        fieldsW.add(cNoLabel);
        JLabel titleLabel = new JLabel("Title Keywords:");
        fieldsW.add(titleLabel);
        JLabel startYLabel = new JLabel("Start Year:");
        fieldsW.add(startYLabel);
        JLabel endYLabel = new JLabel("End Year:");
        fieldsW.add(endYLabel);

        add(fieldsW, BorderLayout.WEST);

        /*QUadrado da esq*/
        JPanel buttonPanel = new JPanel();
        JLabel blank = new JLabel(" ");
        buttonPanel.setLayout(new GridLayout(10, 20));
        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        JButton searchB = new JButton("Search");
        searchB.addActionListener(this);
        buttonPanel.add(reset);
        buttonPanel.add(blank);
        buttonPanel.add(searchB);

        add(buttonPanel, BorderLayout.EAST);

        JPanel m = new JPanel();
        JLabel mTitle = new JLabel("Search Results");
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
        switch (button) {
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
                callNoR.setText(" ");
                titleR.setText(" ");
                startY.setText(" ");
                endY.setText(" ");
                mensageBox.setText(" ");
                break;
            case "Search":

                ArrayList<Book> booksFound;
                ArrayList<Journal> journalsFound;
                boolean bol_calNumber = false;
                boolean bol_title = false;
                boolean bol_startPeriod = false;
                boolean bol_endPeriod = false;
                boolean bol_entry = true;
                int callNumber = 0,
                 startPeriod = 0,
                 endPeriod = 0,
                 pos = -1;
                String title;
                mensageBox.setText("");
                Scanner scan = new Scanner(callNoR.getText());
                try {
                    StringTokenizer token;
                    token = new StringTokenizer(callNoR.getText());
                    if (token.countTokens() != 0) {
                        callNumber = scan.nextInt();
                        bol_calNumber = true;
                    }
                } catch (InputMismatchException e2) {
                    mensageBox.setText("Error!Call No must be an integer!");
                    bol_calNumber = false;
                    bol_entry = false;
                }

                StringTokenizer token;
                token = new StringTokenizer(titleR.getText());
                if (token.countTokens() != 0) {
                    bol_title = true;
                }

                Scanner scan1 = new Scanner(startY.getText());
                if (scan1.hasNextInt()) {
                    startPeriod = scan1.nextInt();
                    bol_startPeriod = true;
                } else {
                    bol_startPeriod = false;
                }

                Scanner scan2 = new Scanner(endY.getText());
                if (scan2.hasNextInt()) {
                    endPeriod = scan2.nextInt();
                    bol_endPeriod = true;
                } else {
                    bol_endPeriod = false;
                }
                if (bol_startPeriod && bol_endPeriod) {
                    pos = 1;
                    if (startPeriod > endPeriod) {
                        mensageBox.setText(mensageBox.getText() + "\n" + "Error!Start year can not occur after the end year!");
                    }
                } else {
                    if (bol_startPeriod && !bol_endPeriod) {
                        pos = 1;
                        bol_endPeriod=true;
                        endPeriod=9999;
                    } else {
                        if (!bol_startPeriod && bol_endPeriod) {
                            pos = 1;
                            bol_startPeriod=true;
                            startPeriod=1000;
                        } else {
                            if (!bol_startPeriod && !bol_endPeriod) {
                                pos = 4;
                            }
                        }
                    }
                }
                if (bol_entry) {
                    if (bol_calNumber && bol_title) {
                        l.search2(callNumber, titleR.getText(), startPeriod, endPeriod, pos, mensageBox);
                    }
                    if (bol_calNumber && !bol_title) {
                        l.search(callNumber, startPeriod, endPeriod, pos, mensageBox);
                    }
                    if (!bol_calNumber && bol_title) {
                        l.search2(titleR.getText(), startPeriod, endPeriod, pos, mensageBox);
                    }
                    if (!bol_calNumber && !bol_title) {
                        l.search(startPeriod, endPeriod, pos, mensageBox);
                    }
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
}
