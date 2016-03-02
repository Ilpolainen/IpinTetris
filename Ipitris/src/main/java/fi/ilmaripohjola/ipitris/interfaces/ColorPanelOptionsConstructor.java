/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Class for setting up ColorPanel with ColorChooser, Button back and desired
 * Buttons for tetris Pieces whose color is to be changed.
 *
 * @author omistaja
 */
public class ColorPanelOptionsConstructor {

    /**
     * Empty constructor.
     */
    public ColorPanelOptionsConstructor() {
    }

    /**
     * Sets up ColorPanel with ColorChooser, Button back and desired Buttons for
     * tetris Pieces whose color is to be changed.
     *
     * @param stateCoordinator ActionListener which is attached to color buttons
     * and JColorChooser.
     */
    public void createColorOptions(StateCoordinator stateCoordinator) {
        JPanel[] panels = stateCoordinator.getStartingScreen().getPanels();
        JColorChooser cc = new JColorChooser(panels[4].getBackground());
        JPanel piecePanel = new JPanel();
        JButton pieceI = new JButton("I");
        JButton pieceT = new JButton("T");
        JButton pieceSquare = new JButton("Square");
        JButton pieceL = new JButton("L");
        JButton pieceJ = new JButton("J");
        JButton pieceS = new JButton("S");
        JButton pieceZ = new JButton("Z");
        connectColorButtons(stateCoordinator, pieceI, pieceT, pieceSquare, pieceL, pieceJ, pieceS, pieceZ);
        attachColorButtons(piecePanel, pieceI, pieceT, pieceSquare, pieceL, pieceJ, pieceS, pieceZ);
        attachPanelParts(panels, cc, piecePanel);
    }

    private void connectColorButtons(StateCoordinator stateCoordinator, JButton pieceI, JButton pieceT, JButton pieceSquare, JButton pieceL, JButton pieceJ, JButton pieceS, JButton pieceZ) {
        pieceI.addActionListener(stateCoordinator);
        pieceT.addActionListener(stateCoordinator);
        pieceSquare.addActionListener(stateCoordinator);
        pieceL.addActionListener(stateCoordinator);
        pieceJ.addActionListener(stateCoordinator);
        pieceS.addActionListener(stateCoordinator);
        pieceZ.addActionListener(stateCoordinator);
    }

    private void attachColorButtons(JPanel piecePanel, JButton pieceI, JButton pieceT, JButton pieceSquare, JButton pieceL, JButton pieceJ, JButton pieceS, JButton pieceZ) {
        piecePanel.add(pieceI);
        piecePanel.add(pieceT);
        piecePanel.add(pieceSquare);
        piecePanel.add(pieceL);
        piecePanel.add(pieceJ);
        piecePanel.add(pieceS);
        piecePanel.add(pieceZ);
    }

    private void attachPanelParts(JPanel[] panels, JColorChooser cc, JPanel piecePanel) {
        panels[4].add(piecePanel, BorderLayout.SOUTH);
        panels[4].add(cc, BorderLayout.CENTER);
    }
}
