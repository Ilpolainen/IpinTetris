/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.application;

import fi.ilmaripohjola.ipitris.interfaces.StateCoordinator;

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
