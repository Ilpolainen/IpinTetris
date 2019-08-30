/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI;

import fi.ilmaripohjola.ipitris.UI.StartingScreen;
import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listens to the slides in StartingScreen and updates the customable values to
 * the corresponding slide values.
 *
 * @author omistaja
 */
public class SliderCoordinator implements ChangeListener {

    private final GameConfiguration configuration;

    /**
     * Sets the class variable StartingScreen to the given one.
     *
     */
    public SliderCoordinator(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            if (source.getName().equals("width")) {
                int width = Math.max((int) source.getValue(), 3);
                this.configuration.setBoardWidth(width);
            }
            if (source.getName().equals("height")) {
                int height = Math.max((int) source.getValue() + 4, 4);
                this.configuration.setBoardHeight(height);
            }
            if (source.getName().equals("scale")) {
                int scale = Math.max((int) source.getValue(), 1);
                this.configuration.setScale(scale);
            }
        }
    }

}
