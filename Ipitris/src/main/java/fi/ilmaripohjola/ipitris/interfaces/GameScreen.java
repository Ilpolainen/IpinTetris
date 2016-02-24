/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private ActionListener stateCoordinator;
    private int width;
    private int height;
    private Thread t;

    public GameScreen(int width, int height, int scale, MyFirstRenderer renderer, KeyPressListener kpl, ActionListener stateCoordinator) {
        this.width = width * scale + 7 * scale + scale * 4 / 11;
        if (height < 12) {
            height = 12;
        }
        this.height = (height - 4) * scale + 55;
        this.scale = scale;
        this.renderer = renderer;
        this.kpl = kpl;
        this.stateCoordinator = stateCoordinator;
    }

    public void setWidth(int newWidth) {
        this.width = newWidth * scale + 7 * scale + scale * 4 / 11;
        frame.setSize(this.width, this.height);
    }

    public void setHeight(int newHeight) {
        if (newHeight < 12) {
            newHeight = 12;
        }
        this.height = (newHeight - 4) * scale + 55;
        frame.setSize(this.width, this.height);
    }

    public void setScale(int scale) {
        this.scale = scale;
        this.renderer.setScale(scale);
    }

    public void resizeFrame() {
        frame.setPreferredSize(new Dimension(width, height));
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
        JPanel buttonsPanel = new JPanel();
        JButton pause = new JButton("PAUSE");
        JButton quit = new JButton("QUIT");
        JButton restart = new JButton("RESTART");
        pause.setFocusable(false);
        quit.setFocusable(false);
        restart.setFocusable(false);
        pause.addActionListener(stateCoordinator);
        quit.addActionListener(stateCoordinator);
        restart.addActionListener(stateCoordinator);

        GridLayout gl = new GridLayout();
        gl.setColumns(3);
        buttonsPanel.setLayout(gl);
        buttonsPanel.add(restart);
        buttonsPanel.add(pause);
        buttonsPanel.add(quit);
        container.add(buttonsPanel, BorderLayout.NORTH);
        container.add(renderer, BorderLayout.CENTER);
        this.frame.addKeyListener(kpl);
    }

    public JFrame getFrame() {
        return frame;
    }

    public MyFirstRenderer getRenderer() {
        return renderer;
    }

    public void start() throws InterruptedException {
        if (t == null) {
            t = new Thread(this, "1");
            t.start();
        }
    }

}
