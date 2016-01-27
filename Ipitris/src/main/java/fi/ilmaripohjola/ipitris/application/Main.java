/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application;

import fi.ilmaripohjola.ipitris.entities.PieceI;
import java.awt.Color;

/**
 *
 * @author omistaja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PieceI pala = new PieceI(Color.BLACK, 2, 1);
        pala.moveDown();
        pala.moveUp();
        pala.moveLeft();
        pala.moveRight();
        System.out.println(pala);
        
        
        
        
        
        // TODO code application logic here
    }
    
}
