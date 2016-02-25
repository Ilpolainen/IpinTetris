/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.Font;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 *
 * @author omistaja
 */
public class SliderCreator {

    public SliderCreator() {
    }

    public void createSliders(StartingScreen ss) {
        JLabel widthName = new JLabel("    WIDTH:");
        JLabel heightName = new JLabel("    HEIGHT:");
        JLabel scaleName = new JLabel("     SCALE:");
        setFonts(widthName, heightName, scaleName);
        JSlider widthSlider = new JSlider(JSlider.HORIZONTAL, 3, 40, ss.getWidth());
        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 4, 40, ss.getHeight());
        JSlider scaleSlider = new JSlider(JSlider.HORIZONTAL, 2, 80, ss.getScale());
        widthSlider.setFocusable(false);
        heightSlider.setFocusable(false);
        scaleSlider.setFocusable(false);
        widthSlider.setName("width");
        heightSlider.setName("height");
        scaleSlider.setName("scale");
        setUpSliders(ss, widthSlider, heightSlider, scaleSlider);
        JPanel[] panels = ss.getPanels();
        panels[2].add(widthName);
        panels[2].add(widthSlider);
        panels[2].add(heightName);
        panels[2].add(heightSlider);
        panels[3].add(scaleName);
        panels[3].add(scaleSlider);
    }

    /**
     * Sets up the options sliders for the startingscreens JFrame. Defins Minor-
     * and Major- TickSpacing, sets labels and ticks visible and adds
     * actionlistener for them.
     *
     * @param ss StartingScreen
     * @param width JSlider widthSlider
     * @param height JSlider height Slider
     * @param scale JSlider Scale Slider
     */
    private void setUpSliders(StartingScreen ss, JSlider width, JSlider height, JSlider scale) {
        width.setMinorTickSpacing(1);
        width.setMajorTickSpacing(1);
        height.setMinorTickSpacing(1);
        height.setMajorTickSpacing(1);
        scale.setMinorTickSpacing(1);
        scale.setMajorTickSpacing(1);
        width.setPaintTicks(true);
        height.setPaintTicks(true);
        scale.setPaintTicks(true);
        width.setPaintLabels(true);
        height.setPaintLabels(true);
        scale.setPaintLabels(true);
        this.createLabelTable(width);
        this.createLabelTable(height);
        this.createLabelTable(scale);
        width.addChangeListener((ChangeListener) ss.getStateCoordinator().getSliderCoordinator());
        height.addChangeListener((ChangeListener) ss.getStateCoordinator().getSliderCoordinator());
        scale.addChangeListener((ChangeListener) ss.getStateCoordinator().getSliderCoordinator());
    }

    /**
     * Creates labels for the slider given as a parameter.
     *
     * @param slider slider on which the labeltable is assigned
     */
    private void createLabelTable(JSlider slider) {
        Hashtable lableTable = new Hashtable();
        lableTable.put(5, new JLabel("5"));
        lableTable.put(10, new JLabel("10"));
        lableTable.put(15, new JLabel("15"));
        lableTable.put(20, new JLabel("20"));
        lableTable.put(25, new JLabel("25"));
        lableTable.put(30, new JLabel("30"));
        lableTable.put(35, new JLabel("35"));
        lableTable.put(40, new JLabel("40"));
        lableTable.put(45, new JLabel("45"));
        lableTable.put(50, new JLabel("50"));
        lableTable.put(55, new JLabel("55"));
        lableTable.put(60, new JLabel("60"));
        lableTable.put(65, new JLabel("65"));
        lableTable.put(70, new JLabel("70"));
        lableTable.put(75, new JLabel("75"));
        lableTable.put(80, new JLabel("80"));
        slider.setLabelTable(lableTable);
    }

    private void setFonts(JLabel widthName, JLabel heightName, JLabel scaleName) {
        Font font = new Font("Greek", 1, 12);
        widthName.setFont(font);
        heightName.setFont(font);
        scaleName.setFont(font);
    }
}
