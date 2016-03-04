/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
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
    private PanelNavigator panelNavigator;
    private int keyToConfigure;
    private KeyConfigurer keyConfigurer;
    private SliderCoordinator sliderCoordinator;

    public StartingScreen(StateCoordinator stateCoordinator) {
        this.panelNavigator = new PanelNavigator(this);
        this.keyConfigurer = new KeyConfigurer(this);
        this.stateCoordinator = stateCoordinator;
        this.sliderCoordinator = new SliderCoordinator(this);
        this.width = 10;
        this.height = 25;
        this.scale = 30;
        this.panels = new JPanel[6];
        this.keyToConfigure = -1;
    }

    public SliderCoordinator getSliderCoordinator() {
        return sliderCoordinator;
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
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
    }

    private void setUpComponents(Container container) {
        this.frame.addKeyListener(keyConfigurer);
        PanelConstructor panelConstructor = new PanelConstructor();
        panelConstructor.setUpPanels(container, panels);
        ColorPanelOptionsConstructor colorPanelOptionsConstructor = new ColorPanelOptionsConstructor();
        colorPanelOptionsConstructor.createColorOptions(stateCoordinator);
        ButtonConstructor buttonConstructor = new ButtonConstructor();
        buttonConstructor.createButtons(panelNavigator, stateCoordinator, panels);
        SliderConstructor sliderConstructor = new SliderConstructor();
        sliderConstructor.createSliders(this);
        attachPanels();
    }
    
    private void attachPanels() {
        CardLayout cl = new CardLayout();
        Container container = this.frame.getContentPane();
        container.setLayout(cl);
        container.add(panels[0], "startPanel");
        container.add(panels[1], "optionsPanel");
        container.add(panels[2], "boardPanel");
        container.add(panels[3], "visualOptionsPanel");
        container.add(panels[4], "colorPanel");
        container.add(panels[5], "keyPanel");
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

    public void start() throws InterruptedException {
        if (t == null) {
            t = new Thread(this, "2");
            t.start();
        }
    }

}
