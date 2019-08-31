/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.application.logic.actions.ApplicationCommand;
import fi.ilmaripohjola.ipitris.gameloop.CommandListener;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.awt.BorderLayout;
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
public class GameScreen implements Runnable  {

    private final JFrame frame;
    private final MyFirstRenderer renderer;
    private final CommandListener commandListener;
    private final GameConfiguration configuration;
    private int width;
    private int height;
    private final int heightOffset;
    private final Thread thread;

    public GameScreen(GameConfiguration configuration, MyFirstRenderer renderer, CommandListener commandListener) {
        this.configuration = configuration;
        this.width = this.configuration.getBoardWidth() * this.configuration.getScale() + 7 * this.configuration.getScale() + this.configuration.getScale() * 4 / 11;
        this.height = configuration.getBoardHeight();
        if (this.height < 12) {
            this.height = 12;
        }
        this.heightOffset = 66;
        this.height = (this.height - 4) * this.configuration.getScale() + this.heightOffset;
        this.renderer = renderer;
        this.commandListener = commandListener;  
        this.frame = new JFrame("IPITRIS");
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.thread = new Thread(this);
    }

    public void checkWidth() {
        this.width = (this.configuration.getBoardWidth()+9) * this.configuration.getScale(); ;
        frame.setSize(this.width, this.height);
    }

    public void setHeight(int newHeight) {
        if (newHeight < 12) {
            newHeight = 12;
        }
        int scale = this.configuration.getScale();
        this.height = (newHeight - 4) * scale + this.heightOffset;
        this.frame.setSize(this.width, this.height);
    }


    public void resizeFrame() {
        frame.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void run() {
        this.frame.addKeyListener(this.commandListener);
        frame.pack();
        this.setActive(true);
        
    }
    
    public void setActive(boolean active) {
        this.frame.setLocationRelativeTo(null);
        this.checkWidth();
        this.frame.setVisible(active);
        this.frame.setAlwaysOnTop(active);
        this.frame.setFocusable(active);
        this.frame.setEnabled(active);
        if (active) {
            this.frame.requestFocus();
            this.frame.toFront();
        }
        
    }

    public void setComponents(ActionListener actionListener) {
        JPanel buttonsPanel = new JPanel();
        JButton pause = new JButton("PAUSE");
        JButton quit = new JButton("QUIT");
        JButton restart = new JButton("RESTART");
        pause.setFocusable(false);
        quit.setFocusable(false);
        restart.setFocusable(false);
        pause.addActionListener(actionListener);
        pause.setActionCommand(ApplicationCommand.PAUSE_GAME.toString());
        quit.addActionListener(actionListener);
        quit.setActionCommand(ApplicationCommand.QUIT_GAME.toString());
        restart.addActionListener(actionListener);
        restart.setActionCommand(ApplicationCommand.RESTART_GAME.toString());

        GridLayout gl = new GridLayout();
        gl.setColumns(3);
        buttonsPanel.setLayout(gl);
        buttonsPanel.add(restart);
        buttonsPanel.add(pause);
        buttonsPanel.add(quit);
        this.frame.getContentPane().add(buttonsPanel, BorderLayout.NORTH);
        this.frame.getContentPane().add(renderer, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }

    public MyFirstRenderer getRenderer() {
        return renderer;
    }

    public void start(ActionListener actionListener) throws InterruptedException {
        this.checkWidth();
        if (!this.thread.isAlive()) {
            setComponents(actionListener);
            thread.start();
        } else {
            this.setActive(true);
        }
    }

}
