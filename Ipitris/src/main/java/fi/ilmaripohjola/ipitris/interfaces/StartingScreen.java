/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StartingScreen implements Runnable {

    private JFrame frame;
    private JPanel[] panels;
    private Thread t;
    private int scale;
    private int width;
    private int height;
    private StateCoordinator stateCoordinator;
    private int keyToConfigure;
    private KeyConfigurer keyConfigurer;
    private PanelConstructor panelConstructor;
    private ButtonConstructor buttonConstructor;
    private SliderCreator sliderCreator;

    public StartingScreen(StateCoordinator stateCoordinator) {
        this.panelConstructor = new PanelConstructor();
        this.buttonConstructor = new ButtonConstructor();
        this.keyConfigurer = new KeyConfigurer(this);
        this.stateCoordinator = stateCoordinator;
        this.sliderCreator = new SliderCreator();
        this.width = 10;
        this.height = 25;
        this.scale = 30;
        this.panels = new JPanel[6];
        this.keyToConfigure = -1;
    }

    public int getKeyToConfigure() {
        return keyToConfigure;
    }

    public void setKeyToConfigure(int keyToConfigure) {
        this.keyToConfigure = keyToConfigure;
    }

    public KeyConfigurer getKeyConfigurer() {
        return keyConfigurer;
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

    public JFrame getFrame() {
        return frame;
    }

    public JPanel[] getPanels() {
        return panels;
    }

    public StateCoordinator getStateCoordinator() {
        return stateCoordinator;
    }

    @Override
    public void run() {
        this.frame = new JFrame("IPITRIS");
        Dimension size = new Dimension(700, 400);
        this.frame.setSize(size);
        this.frame.setLocation(300, 120);
        this.setUpComponents(this.frame.getContentPane());
        List<Component> comps = getAllComponents(this.frame.getContentPane());
        for (Component comp : comps) {
            comp.setFocusable(false);
        }
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void setUpComponents(Container container) {
        this.frame.addKeyListener(keyConfigurer);
        this.panelConstructor.setUpPanels(container, panels);
        this.buttonConstructor.createButtons(this.stateCoordinator, this.panels);
        this.sliderCreator.createSliders(this);
        createColorChooser();
        CardLayout cl = new CardLayout();
        container.setLayout(cl);
        container.add(panels[0], "startPanel");
        container.add(panels[1], "optionsPanel");
        container.add(panels[2], "boardPanel");
        container.add(panels[3], "visualOptionsPanel");
        container.add(panels[4], "colorPanel");
        container.add(panels[5], "keyPanel");
    }

    public void createColorChooser() {
        JColorChooser tcc = new JColorChooser(panels[4].getBackground());
        JPanel piecePanel = new JPanel();
        JButton pieceI = new JButton("I");
        JButton pieceT = new JButton("T");
        JButton pieceSquare = new JButton("Square");
        JButton pieceL = new JButton("L");
        JButton pieceJ = new JButton("J");
        JButton pieceS = new JButton("S");
        JButton pieceZ = new JButton("Z");
        JButton back = new JButton("BACK TO VISUAL OPTIONS");
        piecePanel.add(pieceI);
        piecePanel.add(pieceT);
        piecePanel.add(pieceSquare);
        piecePanel.add(pieceL);
        piecePanel.add(pieceJ);
        piecePanel.add(pieceS);
        piecePanel.add(pieceZ);
        connectColorButtons(pieceI, pieceT, pieceSquare, pieceL, pieceJ, pieceS, pieceZ, back);
        panels[4].add(piecePanel, BorderLayout.SOUTH);
        panels[4].add(tcc, BorderLayout.CENTER);
        panels[4].add(back, BorderLayout.NORTH);
    }

    public List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    public void connectColorButtons(JButton I, JButton T, JButton square, JButton L, JButton J, JButton S, JButton Z, JButton back) {
        I.addActionListener(stateCoordinator);
        T.addActionListener(stateCoordinator);
        square.addActionListener(stateCoordinator);
        L.addActionListener(stateCoordinator);
        J.addActionListener(stateCoordinator);
        S.addActionListener(stateCoordinator);
        Z.addActionListener(stateCoordinator);
        back.addActionListener(stateCoordinator);
    }

    public void start() throws InterruptedException {
        if (t == null) {
            t = new Thread(this, "2");
            t.start();
        }
    }

}
