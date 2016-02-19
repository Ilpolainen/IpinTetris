/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

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

    private StartingScreen startingScreen;

    /**
     * Sets the class variable StartingScreen to the given one.
     *
     * @param startingScreen The Starting screen wich the Listener listens and
     * wich values it handles.
     */
    public SliderCoordinator(StartingScreen startingScreen) {
        this.startingScreen = startingScreen;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            if (source.getName().equals("width")) {
                int width = Math.max((int) source.getValue(), 3);
                this.startingScreen.setWidth(width);
            }
            if (source.getName().equals("height")) {
                int height = Math.max((int) source.getValue() + 4, 4);
                this.startingScreen.setHeight(height);
            }
            if (source.getName().equals("scale")) {
                int scale = Math.max((int) source.getValue(), 1);
                this.startingScreen.setScale(scale);
            }
        }
    }

}
