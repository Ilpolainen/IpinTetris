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
    private int scale;

    public TetrisInterface(Logic tetris, int scale) {        
        this.tetris = tetris;
        this.scale = scale;
        this.renderer = new Renderer(tetris, scale);
    }
    
     @Override
    public void run() {
        frame = new JFrame("IPITRIS");
        int width = tetris.getTable().getWidth()*scale+10;
        int height = (tetris.getTable().getHeight()-4)*scale+30;

        frame.setPreferredSize(new Dimension(width, height));
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void setComponents(Container container) {
        
        container.add(renderer);
        KeyPressListener kpl = new KeyPressListener(tetris);
        this.frame.addKeyListener(kpl);
    }

    public Updatable getUpdatable() {
        return this.renderer;
    }
    
    public JFrame getFrame() {
        return frame;
    }

    
    
    public Logic getLogic() {
        return tetris;
    }

    public Renderer getRenderer() {
        return renderer;
    }
    
    
    
    
}
