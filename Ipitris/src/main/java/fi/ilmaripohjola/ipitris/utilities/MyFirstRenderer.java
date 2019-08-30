/**
 * Renderer handles drawing of tetris game*s current situation.
 */
package fi.ilmaripohjola.ipitris.utilities;

import fi.ilmaripohjola.ipitris.application.logic.GameConfiguration;
import fi.ilmaripohjola.ipitris.entities.Block;
import fi.ilmaripohjola.ipitris.entities.pieces.Piece;
import fi.ilmaripohjola.ipitris.entities.GameTable;
import fi.ilmaripohjola.ipitris.gamelogic.GameState;
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

    private final GameState gameState;
    private final GameConfiguration configuration;

    public MyFirstRenderer(GameState gameState, GameConfiguration configuration) {
        this.gameState = gameState;
        this.configuration = configuration;
    }

    @Override
    public void updateNow() {
        this.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        int scale = this.configuration.getScale();
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, this.configuration.getBoardWidth() * scale, (gameState.getTable().getHeight() - 4) * scale);
        drawTable(g, gameState.getTable(),scale);
        if (gameState.getCurrent() != null) {
            drawPiece(g, gameState.getCurrent(), 0, 0,scale);
        }
        
        showInfo(g,scale,2);
        if (gameState.isEnded()) {
            writeGameOver(g);
        }
    }

    protected void drawBlock(Graphics g, Block block, int x, int y, int scale) {
        g.setColor(Color.BLACK);
        g.drawRect((block.getX()) * scale + x, (block.getY() - 4) * scale + y, scale, scale);
        g.setColor(block.getColor());
        g.fillRect((block.getX()) * scale + 1 + x, (block.getY() - 4) * scale + 1 + y, scale - 1, scale - 1);
    }

    protected void drawPiece(Graphics g, Piece p, int x, int y, int scale) {
        Block[] blocks = p.getBlocks();
        g.setColor(p.getColor());
        for (Block block : blocks) {
            drawBlock(g, block, x, y, scale);
        }
    }

    protected void drawTable(Graphics g, GameTable t, int scale) {
        Block[][] blocks = t.getBlocks();
        for (int i = 0; i < t.getWidth(); i++) {
            for (int j = 4; j < t.getHeight(); j++) {
                if (blocks[i][j] != null && blocks[i][j].getY() >= 4) {
                    drawBlock(g, blocks[i][j], 0, 0,scale);
                }
            }
        }
    }

    public void writeGameOver(Graphics g) {
        Font f = new Font("Greek", 0, this.configuration.getScale() * 4 / 3);
        FontMetrics metrics = g.getFontMetrics(f);
        g.setFont(f);
        String GO = "GAME OVER";
        g.setColor(Color.BLACK);
        g.drawString(GO, gameState.getTable().getWidth() * this.configuration.getScale() / 2 - (metrics.stringWidth(GO) / 2), gameState.getTable().getHeight() / 3 * this.configuration.getScale());
    }

    public void showPoints(Graphics g, int scale,int offset) {
        Font f = new Font("Greek", 0, scale);
        g.setFont(f);
        String points = "POINTS: " + this.gameState.getPoints();
        g.setColor(Color.BLACK);
        g.drawString(points, (gameState.getTable().getWidth() + offset) * scale, scale * 5/2);

    }

    public void showLevel(Graphics g,int scale,int offset) {
        Font f = new Font("Greek", 0, scale);
        g.setFont(f);
        String level = "LEVEL: " + this.gameState.getLevel();
        g.setColor(Color.BLACK);
        g.drawString(level, (gameState.getTable().getWidth() + offset) * scale, scale * 4/3);
    }

    public void showInfo(Graphics g, int scale, int offset) {
        showLevel(g,scale,offset);
        showPoints(g,scale,offset);
        showNext(g,scale,offset);
    }

    public void showNext(Graphics g, int scale,int offset) {
        g.setColor(Color.BLACK);
        g.drawRect((offset + gameState.getTable().getWidth()) * scale, 3 * scale, 5 * scale, 5 * scale);
        Piece p = gameState.getGenerator().getNext();
        if (p.getClass().getSimpleName().equals("PieceI")) {
            drawPiece(g, p, (gameState.getTable().getWidth() - p.getX() + 2 + offset) * scale, 7 * scale + scale / 2,scale);
        } else if (p.getClass().getSimpleName().equals("PieceJ") || p.getClass().getSimpleName().equals("PieceZ")) {
            drawPiece(g, p, (gameState.getTable().getWidth() - p.getX() + 2 + offset) * scale + scale / 2, 7 * scale,scale);
        } else if (p.getClass().getSimpleName().equals("PieceSquare")) {
            drawPiece(g, p, (gameState.getTable().getWidth() - p.getX() + 2 + offset) * scale - scale / 2, 7 * scale - scale / 2,scale);
        } else if (p.getClass().getSimpleName().equals("PieceT")) {
            drawPiece(g, p, (gameState.getTable().getWidth() - p.getX() + 2 + offset) * scale, 7 * scale - scale / 2,scale);
        } else {
            drawPiece(g, p, (gameState.getTable().getWidth() - p.getX() + 2 + offset) * scale - scale / 2, 7 * scale,scale);
        }
    }

}
