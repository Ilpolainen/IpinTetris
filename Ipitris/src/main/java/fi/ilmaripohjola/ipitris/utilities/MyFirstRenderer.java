/**
 * Renderer handles drawing of tetris game*s current situation.
 */
package fi.ilmaripohjola.ipitris.utilities;

import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.Piece;
import fi.ilmaripohjola.ipitris.entities.PieceI;
import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class MyFirstRenderer extends JPanel implements Renderer {

    private TetrisLogic tetris;
    private int scale;

    public MyFirstRenderer(TetrisLogic tetris, int scale) {
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
        g.drawRect(0, 0, tetris.getTable().getWidth() * scale, (tetris.getTable().getHeight() - 4) * scale);
        drawTable(g, tetris.getTable());
        drawPiece(g, tetris.getCurrent(), 0, 0);
        showInfo(g);
        if (this.tetris.getContinues() == false) {
            writeGameOver(g);
        }
    }

    protected void drawBlock(Graphics g, Block block, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawRect((block.getX()) * scale + x, (block.getY() - 4) * scale + y, scale, scale);
        g.setColor(block.getColor());
        g.fillRect((block.getX()) * scale + 1 + x, (block.getY() - 4) * scale + 1 + y, scale - 1, scale - 1);
    }

    protected void drawPiece(Graphics g, Piece p, int x, int y) {
        Block[] blocks = p.getBlocks();
        g.setColor(p.getColor());
        for (Block block : blocks) {
            drawBlock(g, block, x, y);
        }
    }

    protected void drawTable(Graphics g, Table t) {
        Block[][] blocks = t.getBlocks();
        for (int i = 0; i < t.getWidth(); i++) {
            for (int j = 4; j < t.getHeight(); j++) {
                if (blocks[i][j] != null && blocks[i][j].getY() >= 4) {
                    drawBlock(g, blocks[i][j], 0, 0);
                }
            }
        }
    }

    public void writeGameOver(Graphics g) {
        Font f = new Font("Greek", 0, scale * 4 / 3);
        FontMetrics metrics = g.getFontMetrics(f);
        g.setFont(f);
        String GO = "GAME OVER";
        g.setColor(Color.BLACK);
        g.drawString(GO, tetris.getTable().getWidth() * this.scale / 2 - (metrics.stringWidth(GO) / 2), tetris.getTable().getHeight() / 3 * this.scale);
    }

    public void showPoints(Graphics g) {
        Font f = new Font("Greek", 0, scale);
        g.setFont(f);
        String points = "POINTS: " + this.tetris.getPoints();
        FontMetrics metrics = g.getFontMetrics(f);
        g.setColor(Color.BLACK);
        g.drawString(points, (tetris.getTable().getWidth() + 1) * scale, scale * 5/2);

    }

    public void showLevel(Graphics g) {
        Font f = new Font("Greek", 0, scale);
        g.setFont(f);
        String level = "LEVEL: " + this.tetris.getLevel();
        FontMetrics metrics = g.getFontMetrics(f);
        g.setColor(Color.BLACK);
        g.drawString(level, (tetris.getTable().getWidth() + 1) * scale, scale * 4/3);
    }

    public void showInfo(Graphics g) {
        showLevel(g);
        showPoints(g);
        showNext(g);
    }

    public void showNext(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect((1 + tetris.getTable().getWidth()) * scale, 3 * scale, 5 * scale, 5 * scale);
        Piece p = tetris.getGenerator().getNext();
        if (p.getClass().getSimpleName().equals("PieceI")) {
            drawPiece(g, p, (tetris.getTable().getWidth() - p.getX() + 3) * scale, 7 * scale + scale / 2);
        } else if (p.getClass().getSimpleName().equals("PieceJ") || p.getClass().getSimpleName().equals("PieceZ")) {
            drawPiece(g, p, (tetris.getTable().getWidth() - p.getX() + 3) * scale + scale / 2, 7 * scale);
        } else if (p.getClass().getSimpleName().equals("PieceSquare")) {
            drawPiece(g, p, (tetris.getTable().getWidth() - p.getX() + 3) * scale - scale / 2, 7 * scale - scale / 2);
        } else if (p.getClass().getSimpleName().equals("PieceT")) {
            drawPiece(g, p, (tetris.getTable().getWidth() - p.getX() + 3) * scale, 7 * scale - scale / 2);
        } else {
            drawPiece(g, p, (tetris.getTable().getWidth() - p.getX() + 3) * scale - scale / 2, 7 * scale);
        }
    }

}
