/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import fi.ilmaripohjola.ipitris.utilities.Updatable;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author omistaja
 */
public class TetrisInterface implements Runnable {

    private JFrame frame;
    private Logic tetris;
    private Renderer renderer;

    public TetrisInterface(Logic tetris) {        
        this.tetris = tetris;        
    }
    
     @Override
    public void run() {
        frame = new JFrame("Matopeli");
        int width = tetris.getTable().getWidth()*30 + 40;
        int height = tetris.getTable().getHeight()*30 +20;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void setComponents(Container container) {
        this.renderer = new Renderer(tetris);
        container.add(renderer);
        KeyPressListener kpl = new KeyPressListener(tetris);
        this.frame.addKeyListener(kpl);
        // Huom! Luo ensin piirtoalusta jonka lisäät container-olioon
        // Luo vasta tämän jälkeen näppäimistönkuuntelija, jonka lisäät frame-oliolle
    }

    public Updatable getPaivitettava() {
        return this.renderer;
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
