/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyRenderLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author omistaja
 */
public class StateCoordinator implements ActionListener {

    private StartingScreen startingScreen;
    private SliderCoordinator sliderCoordinator;

    public StateCoordinator() throws InterruptedException {        
        this.startingScreen = new StartingScreen(this);
        this.sliderCoordinator = new SliderCoordinator(this.startingScreen);
    }

    public SliderCoordinator getSliderCoordinator() {
        return sliderCoordinator;
    }
    
    
    
    public void start() throws InterruptedException {
        startingScreen.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {
            try {
                setUpGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(StateCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals("TRASH")) {
            makeSound();
        }
        if (e.getActionCommand().equals("OPTIONS")) {
            showOptionsPanel();
        }
        if (e.getActionCommand().equals("CONFIRM")) {
            showStartPanel();
        }
        if (e.getActionCommand().equals("BOARD OPTIONS")) {
            showBoardPanel();
        }
        if (e.getActionCommand().equals("BACK")) {
            showOptionsPanel();
        }
        if (e.getActionCommand().equals("QUIT")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("VISUAL OPTIONS")) {
            showVisualPanel();
        }
    }

    private void setUpGame() throws InterruptedException {
        int width = startingScreen.getWidth();
        int height = startingScreen.getHeight();
        System.out.println(width);
        System.out.println(height);
        Table table = new Table(width, height);
        PieceGenerator generator = new PieceGenerator(new Random(), width);
        TetrisLogic tetris = new TetrisLogic(table, generator);
        KeyPressListener kpl = new KeyPressListener(tetris);
        MyFirstRenderer renderer = new MyFirstRenderer(tetris, startingScreen.getScale());
        GameScreen gameScreen = new GameScreen(width, height, startingScreen.getScale(), renderer, kpl);
        MyRenderLoop renderLoop = new MyRenderLoop(renderer, tetris);
        MyGameLoop gameLoop = new MyGameLoop(renderer, kpl, tetris);
        gameScreen.start();
        renderLoop.start();
        startingScreen.getFrame().setVisible(false);
        gameLoop.start();
    }

    
    
    private void setColors() {
        //HAE TÄSSÄ VÄRIT
//        this.generator.setColors(Color.red, Color.blue, Color.red, Color.red, Color.red, Color.red, Color.red);
    }

    private void showStartPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "startPanel");
    }

    private void showOptionsPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "optionsPanel");
    }
    
    private void showBoardPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "boardPanel");
    }
    
    private void showVisualPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "visualOptionsPanel");
    }

    public void makeSound() {

    }
    
}
