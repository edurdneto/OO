/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

/**
 *
 * @author eduardo
 */
public class FirstWindow extends JFrame implements ActionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT =600;
    //PARA Testar
    LibrarySearch l;
    String output;
    
    FirstWindow(LibrarySearch l,String output){
        super("Library");
        this.output=output;
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));
        this.l=l;
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
        
        JLabel demonstration= new JLabel("<html><p>Welcome!This is a LibrarySearch program. Use the menu command to "
                + "choose one of the three functions:Add, search or quit.</p></html>",SwingConstants.CENTER);
        add(demonstration);
        
        JMenuBar bar=new JMenuBar();
        bar.add(com);
        setJMenuBar(bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttom=e.getActionCommand();
        if(buttom.equals("add")){
            dispose();
            AddWindow gui=new AddWindow(l,output);
            gui.setVisible(true);
        } else {
            if(buttom.equals("search")){
                dispose();
                SearchWindow gui=new SearchWindow(l,output);
                gui.setVisible(true);
            } else {
                System.exit(0);
            }
        }
    }
    
}
