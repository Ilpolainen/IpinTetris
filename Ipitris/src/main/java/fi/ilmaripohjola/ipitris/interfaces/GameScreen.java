/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author omistaja
 */
public class GameScreen implements Runnable {

    private JFrame frame;
    private MyFirstRenderer renderer;
    private int scale;
    private KeyPressListener kpl;
    private int width;
    private int height;
    private Thread t;

    public GameScreen(int width, int height, int scale, MyFirstRenderer renderer, KeyPressListener kpl) {
        this.width = width * scale + 7 * scale + scale/3;
        if (height<12) {
            height=12;
        }
        this.height = (height-4) * scale + 30;         
        this.scale = scale;
        this.renderer = renderer;
        this.kpl = kpl;
    }

    @Override
    public void run() {
        frame = new JFrame("IPITRIS");        
        frame.setPreferredSize(new Dimension(width, height));         
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void setComponents(Container container) {
        container.add(renderer);
        this.frame.addKeyListener(kpl);
    }

    

    public JFrame getFrame() {
        return frame;
    }

    public MyFirstRenderer getRenderer() {
        return renderer;
    }

    public void start() throws InterruptedException {
        System.out.println("Creating tetris window");        
        if (t == null) {
            t = new Thread(this, "1");
            t.start();            
        }
    }

}
