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
 * Constructs sliders.
 *
 * @author omistaja
 */
public class SliderConstructor {

    /**
     * Empty Constructor.
     */
    public SliderConstructor() {
    }

    /**
     * Creates and sets up sliders for tetris StartingScreen.
     *
     * @param ss StartingScreen on which to attach the sliders created.
     */
    public void createSliders(StartingScreen ss) {
        JLabel widthName = new JLabel("    WIDTH:");
        JLabel heightName = new JLabel("    HEIGHT:");
        JLabel scaleName = new JLabel("     SCALE:");
        setFonts(widthName, heightName, scaleName);
        JSlider widthSlider = new JSlider(JSlider.HORIZONTAL, 3, 40, ss.getWidth());
        JSlider heightSlider = new JSlider(JSlider.HORIZONTAL, 4, 40, ss.getHeight());
        JSlider scaleSlider = new JSlider(JSlider.HORIZONTAL, 2, 80, ss.getScale());
        addSliderTags(widthSlider, heightSlider, scaleSlider);
        setUpSliders(ss, widthSlider, heightSlider, scaleSlider);
        JPanel[] panels = ss.getPanels();
        panels[2].add(widthName);
        panels[2].add(widthSlider);
        panels[2].add(heightName);
        panels[2].add(heightSlider);
        panels[3].add(scaleName);
        panels[3].add(scaleSlider);
    }

    private void setUpSliders(StartingScreen ss, JSlider width, JSlider height, JSlider scale) {
        setTickSpacing(width, height, scale);
        setPaintBooleans(width, height, scale);
        createLabelTable(width, height, scale);
        connectSliders(ss, width, height, scale);
    }

    private void setTickSpacing(JSlider width, JSlider height, JSlider scale) {
        width.setMinorTickSpacing(1);
        width.setMajorTickSpacing(1);
        height.setMinorTickSpacing(1);
        height.setMajorTickSpacing(1);
        scale.setMinorTickSpacing(1);
        scale.setMajorTickSpacing(1);
    }

    private void addSliderTags(JSlider width, JSlider height, JSlider scale) {
        width.setName("width");
        height.setName("height");
        scale.setName("scale");
    }

    private void setPaintBooleans(JSlider width, JSlider height, JSlider scale) {
        width.setPaintTicks(true);
        height.setPaintTicks(true);
        scale.setPaintTicks(true);
        width.setPaintLabels(true);
        height.setPaintLabels(true);
        scale.setPaintLabels(true);
    }

    /**
     * Creates labels for the slider given as a parameter.
     *
     * @param slider slider on which the labeltable is assigned
     */
    private void createLabelTable(JSlider width, JSlider height, JSlider scale) {
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
        setLableTables(lableTable, width, height, scale);
    }

    private void setLableTables(Hashtable lableTable, JSlider width, JSlider height, JSlider scale) {
        width.setLabelTable(lableTable);
        height.setLabelTable(lableTable);
        scale.setLabelTable(lableTable);
    }

    private void connectSliders(StartingScreen ss, JSlider width, JSlider height, JSlider scale) {
        width.addChangeListener((ChangeListener) ss.getSliderCoordinator());
        height.addChangeListener((ChangeListener) ss.getSliderCoordinator());
        scale.addChangeListener((ChangeListener) ss.getSliderCoordinator());
    }

    private void setFonts(JLabel widthName, JLabel heightName, JLabel scaleName) {
        Font font = new Font("Greek", 1, 12);
        widthName.setFont(font);
        heightName.setFont(font);
        scaleName.setFont(font);
    }
}
