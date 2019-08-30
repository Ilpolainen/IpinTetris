/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI;

import fi.ilmaripohjola.ipitris.UI.StartingScreen;
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

    private final StartingScreen startingScreen;

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
        switch (e.getActionCommand()) {
            case "OPTIONS":
            case "BACK":
                showOptionsPanel();
                break;
            case "BOARD OPTIONS":
                showBoardPanel();
                break;
            case "BACK TO VISUAL OPTIONS":
            case "VISUAL OPTIONS":
                showVisualPanel();
                break;
            case "KEY OPTIONS":
                showKeyPanel();
                break;
            case "COLORS":
                showColorsPanel();
                break;
            case "CONFIRM":
                showStartPanel();
                break;
            default:
                break;
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
