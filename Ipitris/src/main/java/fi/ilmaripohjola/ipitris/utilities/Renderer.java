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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class Renderer extends JPanel implements Updatable {
    
    private Logic tetris;
    private int scale;

    public Renderer(Logic tetris, int scale) {
        this.tetris = tetris;
        this.scale = scale;
    }

    @Override
    public void updateNow() {  
        this.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);        
        g.drawRect(0, 0, tetris.getTable().getWidth()*scale, (tetris.getTable().getHeight()-4)*scale);
        drawTable(g, tetris.getTable());
        drawPiece(g, tetris.getCurrent());
        showLevel(g);
        showPoints(g);
        if (this.tetris.getContinues()==false) {
            writeGameOver(g);
        }
    }
    
    protected void drawBlock(Graphics g, Block block) {        
        g.setColor(Color.BLACK);
        g.drawRect(block.getX()*scale, (block.getY()-4)*scale, scale, scale);
        g.setColor(block.getColor());
        g.fillRect(block.getX()*scale+1, (block.getY()-4)*scale+1, scale-1, scale-1);
    }
    
    protected void drawPiece(Graphics g, Piece p) {
        Block[] blocks = p.getBlocks();
        g.setColor(p.getColor());
        for (Block block : blocks) {
            if (block.getY()>=4) {
                 drawBlock(g, block);
            }           
        }
    }
    
    protected void drawTable(Graphics g, Table t) {
        Block[][] blocks = t.getBlocks();
        for (int i = 0; i < t.getWidth(); i++) {
            for (int j = 4; j < t.getHeight(); j++) {
                if (blocks[i][j]!=null && blocks[i][j].getY()>=4) {
                    drawBlock(g, blocks[i][j]);
                }
            }
        }        
    }
    
    public void writeGameOver(Graphics g) {
        Font f = new Font("Greek",0,42);
        FontMetrics metrics = g.getFontMetrics(f);
        g.setFont(f);
        String GO = "GAME OVER";
        g.setColor(Color.BLACK);
        
        g.drawString(GO, tetris.getTable().getWidth()*this.scale/2 - (metrics.stringWidth(GO)/2), tetris.getTable().getHeight()/3*this.scale);
    }
    
    public void showPoints(Graphics g) {
        Font f = new Font("Greek", 0, 20);        
        g.setFont(f);        
        String points = "POINTS: " + this.tetris.getPoints();
        FontMetrics metrics = g.getFontMetrics(f);
        g.setColor(Color.BLACK);
        g.drawString(points, tetris.getTable().getWidth()*this.scale - (metrics.stringWidth(points))-10, metrics.getMaxAscent());
        
    }
    
    public void showLevel(Graphics g) {
        Font f = new Font("Greek", 0, 20);        
        g.setFont(f);        
        String level = "LEVEL: " + this.tetris.getLevel();
        FontMetrics metrics = g.getFontMetrics(f);
        g.setColor(Color.BLACK);
        g.drawString(level, 10, metrics.getMaxAscent());
    }
}
