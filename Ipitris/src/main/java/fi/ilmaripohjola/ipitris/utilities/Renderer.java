/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.utilities;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class Renderer extends JPanel implements Updatable {
    
    private Logic tetris;

    public Renderer(Logic tetris) {
        this.tetris = tetris;
    }

    @Override
    public void updateNow() {
        this.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(200, 60, tetris.getTable().getWidth(), tetris.getTable().getHeight()); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected void drawBlock(Graphics g, Block block) {
        g.setColor(block.getColor());
        g.drawRect(block.getX()*30, block.getY()*30, 30, 30);
    }
    
    protected void drawPiece(Graphics g, Piece p) {
        Block[] blocks = p.getBlocks();
        g.setColor(p.getColor());
        for (Block block : blocks) {
            drawBlock(g, block);
        }
    }
    
    protected void drawTable(Graphics g, Table t) {
        Block[][] blocks = t.getBlocks();
        for (int i = 0; i < t.getWidth(); i++) {
            for (int j = 0; j < t.getHeight(); j++) {
                if (blocks[i][j]!=null) {
                    drawBlock(g, blocks[i][j]);
                }
            }
        }
    }
}
