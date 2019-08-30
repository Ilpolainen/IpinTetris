/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.utilities;

import fi.ilmaripohjola.ipitris.gamelogic.GameState;

/**
 * Abstract class which is meant to be a baseclass for renderers. Only requires
 * updateNow() implementation from the Classes that implement this.
 *
 * @author omistaja
 */
public interface Renderer {

    /**
     * Meant to update the screen image.
     */
    void updateNow();
}
