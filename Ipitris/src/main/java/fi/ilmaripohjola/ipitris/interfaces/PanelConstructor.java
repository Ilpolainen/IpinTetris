/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * PanelConstructor helps Class StartingScreen, to construct it's frame's
 * panels.
 *
 * @author omistaja
 */
public class PanelConstructor {

    /**
     * Empty Constructor.
     */
    public PanelConstructor() {
    }

    /**
     * This Method constructs panels for StartingScreen's frame and sets up all
     * the necessary settings needed for a tetris StartingPanel. It creates
     * those layouts and attaches the panels for the StartingScreens Panel
     * -array.
     *
     * @param container
     * @param panels
     */
    public void setUpPanels(Container container, JPanel[] panels) {
        GridLayout cl1 = new GridLayout();
        GridLayout cl2 = new GridLayout();
        GridLayout cl3 = new GridLayout();
        GridLayout cl4 = new GridLayout();
        BorderLayout cl5 = new BorderLayout();
        GridLayout cl6 = new GridLayout();
        cl1.setRows(4);
        cl2.setRows(4);
        cl3.setRows(5);
        cl4.setRows(4);
        cl6.setRows(5);
        JPanel startPanel = new JPanel(cl1);
        JPanel optionsPanel = new JPanel(cl2);
        JPanel boardPanel = new JPanel(cl3);
        JPanel visualOptionsPanel = new JPanel(cl4);
        JPanel colorPanel = new JPanel(cl5);
        JPanel keysPanel = new JPanel(cl6);
        panels[0] = startPanel;
        panels[1] = optionsPanel;
        panels[2] = boardPanel;
        panels[3] = visualOptionsPanel;
        panels[4] = colorPanel;
        panels[5] = keysPanel;
    }
}
