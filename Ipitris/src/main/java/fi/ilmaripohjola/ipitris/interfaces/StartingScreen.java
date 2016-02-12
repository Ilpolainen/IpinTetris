/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author omistaja
 */
public class StartingScreen implements Runnable {

    private JFrame frame;    
    private Thread t;    
    private int scale;
    private int width;
    private int height;
    
    
    public StartingScreen() {
        this.width = 10;
        this.height = 25;       
        scale = 30;
    }

    @Override
    public void run() {
        this.frame = new JFrame("IPITRIS");
        Dimension size = new Dimension(600, 400);
        this.frame.setSize(size);
        this.frame.setLocation(300, 120);
        this.setUpComponents(this.frame.getContentPane());
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setUpComponents(Container container) {
        JButton start = new JButton("START");
        JButton options = new JButton("OPTIONS");
        JButton trash = new JButton("TRASH");
        JButton quit = new JButton("QUIT");
        JButton confirm = new JButton("CONFIRM");        
        passFocus(start, options, trash, quit, confirm);
        
        JPanel startPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        attachButtons(startPanel, optionsPanel, start, options, trash, quit, confirm);
        
        GridLayout cl1 = new GridLayout();
        GridLayout cl2 = new GridLayout();
        startPanel.setLayout(cl1);
        optionsPanel.setLayout(cl2);
        cl2.setRows(4);
        cl1.setRows(4);        
        CardLayout cl = new CardLayout();
        container.setLayout(cl);
        container.add(startPanel, "startPanel");
        container.add(optionsPanel, "optionsPanel");
        ActionListener listener = this.makeActionListener(cl, container, this);
        connectButtons(listener, start, options, trash, quit, confirm);
    }
    
    public void connectButtons(ActionListener listener, JButton start, JButton options, JButton trash, JButton exit, JButton confirm) {
        start.addActionListener(listener);
        exit.addActionListener(listener);       
        trash.addActionListener(listener);
        options.addActionListener(listener);
        confirm.addActionListener(listener);
    }
    
    public void attachButtons(JPanel startPanel, JPanel optionsPanel, JButton start, JButton options, JButton trash, JButton exit, JButton confirm) {
        optionsPanel.add(confirm);
        startPanel.add(start);
        startPanel.add(options);
        startPanel.add(trash);
        startPanel.add(exit);
    }
    
    public void passFocus(JButton start, JButton options, JButton trash, JButton exit, JButton confirm) {
        start.setFocusable(false);
        options.setFocusable(false);
        confirm.setFocusable(false);
        trash.setFocusable(false);
        exit.setFocusable(false);
    }

    public ActionListener makeActionListener(CardLayout cl, Container container, StartingScreen screen) {
        ActionListener controller = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("OPTIONS")) {
                    cl.show(container, "optionsPanel");
                }
                if (e.getActionCommand().equals("CONFIRM")) {
                    cl.show(container, "startPanel");
                }
                if (e.getActionCommand().equals("START")) {
                    try {
                        startGame();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StartingScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getActionCommand().equals("EXIT")) {
                    System.exit(0);
                }
                
            }

        };
        return controller;
    }

    public void startGame() throws InterruptedException {
        Table table = new Table(this.width, this.height);                
        Logic tetris = new Logic(table);
        KeyPressListener listener = new KeyPressListener(tetris);
        Renderer renderer = new Renderer(tetris, scale);
        TetrisInterface gameScreen = new TetrisInterface(table.getWidth(), table.getHeight(), scale, renderer, listener);
        MyGameLoop gameLoop = new MyGameLoop(renderer, listener, tetris);
        gameScreen.start(gameLoop);        
        this.frame.setVisible(false);
    }

    public void start() throws InterruptedException {        
        System.out.println("Starting Menu");
        if (t == null) {
            t = new Thread(this, "2");           
            t.start();
        }
    }

}
