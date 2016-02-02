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
import fi.ilmaripohjola.ipitris.gameengine.GameLoop;
import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.interfaces.TetrisInterface;

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
    public static void main(String[] args) {        
        Table table = new Table(10,25);        
        Logic tetris = new Logic(table, 1);       
        TetrisInterface IF = new TetrisInterface(tetris, 30);
        GameLoop AT = new GameLoop(tetris, IF.getRenderer());
        SwingUtilities.invokeLater(IF);
        AT.start();
        
        
        
        
        
        // TODO code application logic here
    }
    
}
