/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.entities;

/**
 *
 * @author omistaja
 */
public class Table {

    private int width;
    private int height;
    private Block[][] blocks;

    public Table(int width, int height) {
        if (width < 4) {
            width = 4;
        }
        this.width = width;
        if (height < 8) {
            height = 8;
        }
        this.height = height;
        this.blocks = new Block[width][height + 4];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void setSize(int width, int height) {
        if (width < 4) {
            width = 4;
        }
        this.width = width;
        if (height < 8) {
            height = 8;
        }
        this.height = height;
        this.blocks = new Block[width][height + 4];
    }

}
