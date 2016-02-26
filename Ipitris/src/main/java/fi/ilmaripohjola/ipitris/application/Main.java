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
import fi.ilmaripohjola.ipitris.interfaces.GameScreen;
import fi.ilmaripohjola.ipitris.interfaces.StateCoordinator;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;

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
        StateCoordinator stateCoordinator = new StateCoordinator();
        stateCoordinator.start();
    }
    
}
