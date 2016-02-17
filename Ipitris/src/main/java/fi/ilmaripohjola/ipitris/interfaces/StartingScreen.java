/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;

public class StartingScreen implements Runnable {

    private JFrame frame;
    private JPanel[] panels;
    private Thread t;
    private int scale;
    private int width;
    private int height;
    private StateCoordinator stateCoordinator;

    public StartingScreen(StateCoordinator stateCoordinator) {
        this.stateCoordinator = stateCoordinator;
        this.width = 10;
        this.height = 25;
        this.scale = 30;
        this.panels = new JPanel[4];
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
        setUpPanels(container);
        attachButtons();
        createSliders();
//        JColorChooser tcc = new JColorChooser(panels[1].getBackground());
//        panels[1].add(tcc);
        CardLayout cl = new CardLayout();
        container.setLayout(cl);
        container.add(panels[0], "startPanel");
        container.add(panels[1], "optionsPanel");
        container.add(panels[2], "boardPanel");
        container.add(panels[3], "visualOptionsPanel");
    }

    public void connectButtons(JButton start, JButton options, JButton trash, JButton exit, JButton confirm, JButton boardOptions, JButton back, JButton visualOptions, JButton back2) {
        start.addActionListener(stateCoordinator);
        exit.addActionListener(stateCoordinator);
        trash.addActionListener(stateCoordinator);
        options.addActionListener(stateCoordinator);
        confirm.addActionListener(stateCoordinator);
        boardOptions.addActionListener(stateCoordinator);
        back.addActionListener(stateCoordinator);
        visualOptions.addActionListener(stateCoordinator);
        back2.addActionListener(stateCoordinator);
    }

    public void attachButtons() {
        JButton start = new JButton("START");
        JButton options = new JButton("OPTIONS");
        JButton trash = new JButton("TRASH");
        JButton quit = new JButton("QUIT");
        JButton confirm = new JButton("CONFIRM");
        JButton boardOptions = new JButton("BOARD OPTIONS");
        JButton visualOptions = new JButton("VISUAL OPTIONS");
        JButton back = new JButton("BACK");
        JButton back2 = new JButton("BACK");

        passFocus(start, options, trash, quit, confirm, boardOptions, back, visualOptions, back2);
        panels[1].add(confirm);
        panels[1].add(boardOptions);
        panels[1].add(visualOptions);
        panels[0].add(start);
        panels[0].add(options);
        panels[0].add(trash);
        panels[0].add(quit);
        panels[2].add(back);
        panels[3].add(back2);
        connectButtons(start, options, trash, quit, confirm, boardOptions, back, visualOptions, back2);
    }

    public void createSliders() {
        JLabel widthName = new JLabel("    WIDTH:");
        JLabel heightName = new JLabel("    HEIGHT:");
        JLabel scaleName = new JLabel("     SCALE:");
        setFonts(widthName, heightName, scaleName);        
        JSlider widthSlider = new JSlider(JSlider.HORIZONTAL, 3, 40, this.width);
        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 4, 40, this.height);
        JSlider scaleSlider = new JSlider(JSlider.HORIZONTAL, 2, 40, this.scale);
        widthSlider.setName("width");
        heightSlider.setName("height");
        scaleSlider.setName("scale");
        setUpSliders(widthSlider, heightSlider, scaleSlider);
        panels[2].add(widthName);
        panels[2].add(widthSlider);
        panels[2].add(heightName);
        panels[2].add(heightSlider);
        panels[3].add(scaleName);
        panels[3].add(scaleSlider);
    }

    public void passFocus(JButton start, JButton options, JButton trash, JButton exit, JButton confirm, JButton boardOptions, JButton back, JButton visualOptions, JButton back2) {
        start.setFocusable(false);
        options.setFocusable(false);
        confirm.setFocusable(false);
        trash.setFocusable(false);
        exit.setFocusable(false);
        boardOptions.setFocusable(false);
        back.setFocusable(false);
        visualOptions.setFocusable(false);
        back2.setFocusable(false);
    }

    public void setUpPanels(Container container) {
        GridLayout cl1 = new GridLayout();
        GridLayout cl2 = new GridLayout();
        GridLayout cl3 = new GridLayout();
        GridLayout cl4 = new GridLayout();
        cl1.setRows(4);
        cl2.setRows(4);
        cl3.setRows(5);
        cl4.setRows(9);
        JPanel startPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel boardPanel = new JPanel();
        JPanel visualOptionsPanel = new JPanel();
        startPanel.setLayout(cl1);
        optionsPanel.setLayout(cl2);
        boardPanel.setLayout(cl3);
        visualOptionsPanel.setLayout(cl4);
        panels[0] = startPanel;
        panels[1] = optionsPanel;
        panels[2] = boardPanel;
        panels[3] = visualOptionsPanel;
    }
    
    public void setUpSliders(JSlider width, JSlider height, JSlider scale) {
        width.setMinorTickSpacing(1);
        width.setMajorTickSpacing(1);
        height.setMinorTickSpacing(1);
        height.setMajorTickSpacing(1);
        scale.setMinorTickSpacing(1);
        scale.setMajorTickSpacing(1);
        width.setPaintTicks(true);
        height.setPaintTicks(true);
        scale.setPaintTicks(true);
        width.setPaintLabels(true);
        height.setPaintLabels(true);
        scale.setPaintLabels(true);        
        this.createLabelTable(width);
        this.createLabelTable(height);
        this.createLabelTable(scale);
        width.addChangeListener((ChangeListener) this.stateCoordinator.getSliderCoordinator());
        height.addChangeListener((ChangeListener) this.stateCoordinator.getSliderCoordinator());
        scale.addChangeListener((ChangeListener) this.stateCoordinator.getSliderCoordinator());
        
    }
    
    public void createLabelTable(JSlider slider) {
        Hashtable lableTable = new Hashtable();
        lableTable.put(new Integer(5),new JLabel("5"));
        lableTable.put(new Integer(10), new JLabel("10"));
        lableTable.put(new Integer(15), new JLabel("15"));
        lableTable.put(new Integer(20), new JLabel("20"));
        lableTable.put(new Integer(25), new JLabel("25"));
        lableTable.put(new Integer(30), new JLabel("30"));
        lableTable.put(new Integer(35), new JLabel("35"));
        lableTable.put(new Integer(40), new JLabel("40"));
        slider.setLabelTable(lableTable);
    }
    
    public void setFonts(JLabel widthName, JLabel heightName, JLabel scaleName) {
        Font font = new Font("Greek", 1, 12);
        widthName.setFont(font);
        heightName.setFont(font);
        scaleName.setFont(font);
    }

    public void start() throws InterruptedException {
        System.out.println("Starting Menu");
        if (t == null) {
            t = new Thread(this, "2");
            t.start();
        }
    }

}
