/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI;

import fi.ilmaripohjola.ipitris.UI.utilities.ButtonBuilder;
import fi.ilmaripohjola.ipitris.UI.utilities.ColorConfigurer;
import fi.ilmaripohjola.ipitris.UI.utilities.ColorPanelOptionsBuilder;
import fi.ilmaripohjola.ipitris.UI.utilities.KeyConfigurer;
import fi.ilmaripohjola.ipitris.UI.utilities.SliderBuilder;
import fi.ilmaripohjola.ipitris.UI.utilities.PanelBuilder;
import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StartingScreen implements Runnable {

    private final JFrame frame;
    private final JPanel[] panels;
    private final Thread thread;
    private final GameConfiguration configuration;
    private final PanelNavigator panelNavigator;
    private final KeyConfigurer keyConfigurer;
    private final ColorConfigurer colorConfigurer;
    private SliderCoordinator sliderCoordinator;
    private JColorChooser colorChooser;

    public StartingScreen(GameConfiguration configuration) {
        this.panelNavigator = new PanelNavigator(this);
        this.configuration = configuration;
        this.configuration.setScale(30);
        this.keyConfigurer = new KeyConfigurer(this.configuration);
        this.sliderCoordinator = new SliderCoordinator(this.configuration);
        this.frame = new JFrame("IPITRIS");
        this.panels = new JPanel[6];
        this.thread = new Thread(this);
        this.colorChooser = null;
        this.colorConfigurer = new ColorConfigurer(this.configuration);
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    public SliderCoordinator getSliderCoordinator() {
        return sliderCoordinator;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel[] getPanels() {
        return panels;
    }

  

    
    @Override
    public void run() {
        
        Dimension size = new Dimension(700, 400);
        this.frame.setSize(size);
        this.frame.setLocation(300, 120);
        
        List<Component> comps = getAllComponents(this.frame.getContentPane());
        comps.forEach((comp) -> {
            comp.setFocusable(false);
        });
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setActive(true);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
    }

    private void setUpComponents(Container container) {
        this.frame.addKeyListener(keyConfigurer);
        PanelBuilder.setUpPanels(container, this.panels);
        this.colorChooser = new JColorChooser(panels[4].getBackground());
        this.colorConfigurer.setColorChooser(colorChooser);
        ColorPanelOptionsBuilder.createColorOptions(colorConfigurer,this.panels);
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

    private void setActionListeners(ActionListener actionListener) {
        this.setUpComponents(this.frame.getContentPane());
        ButtonBuilder.createButtons(this.panelNavigator, actionListener,this.keyConfigurer, this.panels);
        SliderBuilder.createSliders(this);
        attachPanels();
    }
   
    
    public void start(ActionListener actionListener) throws InterruptedException {
        setActionListeners(actionListener);
        thread.start();  
    }
    
    public void setActive(boolean active) {
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(active);
        this.frame.setAlwaysOnTop(active);
        this.frame.setFocusable(active);
        this.frame.setEnabled(active);
        if (active) {
            this.frame.requestFocus();
        this.frame.toFront();
        }   
    }
}
