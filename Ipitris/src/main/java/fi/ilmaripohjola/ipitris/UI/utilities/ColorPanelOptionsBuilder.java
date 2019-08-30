/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI.utilities;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Class for setting up ColorPanel with ColorChooser, Button back and desired
 * Buttons for tetris Pieces whose color is to be changed.
 *
 * @author omistaja
 */
public class ColorPanelOptionsBuilder {


    /**
     * Sets up ColorPanel with ColorChooser, Button back and desired Buttons for
     * tetris Pieces whose color is to be changed.
     *
     * @param colorConfigurer
     * @param panels
     * @param colorChooser
     */
    public static void createColorOptions(ColorConfigurer colorConfigurer,JPanel[] panels) {
        JPanel piecePanel = new JPanel();
        JButton pieceI = new JButton("I");
        pieceI.setActionCommand("0");
        JButton pieceSquare = new JButton("Square");
        pieceSquare.setActionCommand("1");
        JButton pieceT = new JButton("T");
        pieceT.setActionCommand("2");
        JButton pieceL = new JButton("L");
        pieceL.setActionCommand("3");
        JButton pieceJ = new JButton("J");
        pieceJ.setActionCommand("4");
        JButton pieceS = new JButton("S");
        pieceS.setActionCommand("5");
        JButton pieceZ = new JButton("Z");
        pieceZ.setActionCommand("6");
        ColorPanelOptionsBuilder.connectColorButtons(colorConfigurer, pieceI, pieceT, pieceSquare, pieceL, pieceJ, pieceS, pieceZ);
        ColorPanelOptionsBuilder.attachColorButtons(piecePanel, pieceI, pieceT, pieceSquare, pieceL, pieceJ, pieceS, pieceZ);
        ColorPanelOptionsBuilder.attachPanelParts(panels, colorConfigurer.getColorChooser(), piecePanel);
    }

    private static void connectColorButtons(ActionListener colorConfigurer, JButton pieceI, JButton pieceT, JButton pieceSquare, JButton pieceL, JButton pieceJ, JButton pieceS, JButton pieceZ) {
        pieceI.addActionListener(colorConfigurer);
        pieceT.addActionListener(colorConfigurer);
        pieceSquare.addActionListener(colorConfigurer);
        pieceL.addActionListener(colorConfigurer);
        pieceJ.addActionListener(colorConfigurer);
        pieceS.addActionListener(colorConfigurer);
        pieceZ.addActionListener(colorConfigurer);
    }

    private static void attachColorButtons(JPanel piecePanel, JButton pieceI, JButton pieceT, JButton pieceSquare, JButton pieceL, JButton pieceJ, JButton pieceS, JButton pieceZ) {
        piecePanel.add(pieceI);
        piecePanel.add(pieceT);
        piecePanel.add(pieceSquare);
        piecePanel.add(pieceL);
        piecePanel.add(pieceJ);
        piecePanel.add(pieceS);
        piecePanel.add(pieceZ);
    }

    private static void attachPanelParts(JPanel[] panels, JColorChooser cc, JPanel piecePanel) {
        panels[4].add(piecePanel, BorderLayout.SOUTH);
        panels[4].add(cc, BorderLayout.CENTER);
    }
}
