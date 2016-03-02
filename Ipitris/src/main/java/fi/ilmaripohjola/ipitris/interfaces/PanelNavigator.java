/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * ActionListener specialized to switching between StartingScreens panels.
 *
 * @author omistaja
 */
public class PanelNavigator implements ActionListener {

    private StartingScreen startingScreen;

    /**
     * Constructs PanelNavigator.
     *
     * @param startingScreen The StartingScreen used to get information and
     * objects to this ActionListener.
     */
    public PanelNavigator(StartingScreen startingScreen) {
        this.startingScreen = startingScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OPTIONS") || e.getActionCommand().equals("BACK")) {
            showOptionsPanel();
        } else if (e.getActionCommand().equals("BOARD OPTIONS")) {
            showBoardPanel();
        } else if (e.getActionCommand().equals("BACK TO VISUAL OPTIONS") || e.getActionCommand().equals("VISUAL OPTIONS")) {
            showVisualPanel();
        } else if (e.getActionCommand().equals("KEY OPTIONS")) {
            showKeyPanel();
        } else if (e.getActionCommand().equals("COLORS")) {
            showColorsPanel();
        } else if (e.getActionCommand().equals("CONFIRM")) {
            showStartPanel();
        }
    }

    private void showStartPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "startPanel");
    }

    private void showOptionsPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "optionsPanel");
    }

    private void showBoardPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "boardPanel");
    }

    private void showVisualPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "visualOptionsPanel");
    }

    private void showColorsPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "colorPanel");
    }

    private void showPreviousPanel() {
        JFrame frame = startingScreen.getFrame();
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.previous(frame.getContentPane());
    }

    private void showKeyPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "keyPanel");
    }
}
