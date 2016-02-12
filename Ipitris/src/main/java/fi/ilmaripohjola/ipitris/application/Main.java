/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application;

import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.PieceJ;
import fi.ilmaripohjola.ipitris.entities.PieceS;
import fi.ilmaripohjola.ipitris.entities.PieceSquare;
import fi.ilmaripohjola.ipitris.entities.PieceT;
import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.interfaces.KeyPressListener;

import fi.ilmaripohjola.ipitris.interfaces.StartingScreen;
import fi.ilmaripohjola.ipitris.interfaces.TetrisInterface;
import fi.ilmaripohjola.ipitris.utilities.Renderer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.time.Clock;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author omistaja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {        
//      
//        Table table = new Table(10,25);
//        int scale = 30;
//        Logic tetris = new Logic(table);
//        KeyPressListener listener = new KeyPressListener(tetris);
//        Renderer renderer = new Renderer(tetris, scale);
//        TetrisInterface IF = new TetrisInterface(table.getWidth(), table.getHeight(), scale, renderer, listener);
        StartingScreen SS = new StartingScreen();
        SS.start();
//        MyGameLoop loop = new MyGameLoop(renderer, listener, tetris);
//        SwingUtilities.invokeLater(IF);
//        IF.start();
//        loop.run();
//        
        
//        StartingScreen SS = new StartingScreen();
//        SwingUtilities.invokeLater(SS);

        
        
        
        
        
        // TODO code application logic here
    }
    
}
