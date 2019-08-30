/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ilmari Pohjola
 */
public class ColorConfigurer implements ActionListener {
    private final GameConfiguration configuration;
    private JColorChooser colorChooser;

    public ColorConfigurer(GameConfiguration configuration) {
        this.configuration = configuration;
        this.colorChooser = null;
    }
    
    public void setColorChooser(JColorChooser colorChooser) {
        this.colorChooser = colorChooser;
    }

    public JColorChooser getColorChooser() {
        return colorChooser;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        int i = Integer.parseInt(e.getActionCommand());
        this.configuration.setColor(i, this.colorChooser.getColor());
    }


}
