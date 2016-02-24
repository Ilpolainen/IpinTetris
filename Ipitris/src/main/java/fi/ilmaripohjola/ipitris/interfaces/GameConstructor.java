/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyRenderLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import fi.ilmaripohjola.ipitris.utilities.Renderer;
import java.util.Random;

/**
 *
 * @author omistaja
 */
public class GameConstructor {
    
    private Table table;
    private TetrisLogic tetris;
    private PieceGenerator generator;
    private KeyPressListener kpl;
    private MyFirstRenderer renderer;
    private GameScreen gameScreen;
    private MyRenderLoop renderLoop;
    private MyGameLoop gameLoop;
    private StateCoordinator coordinator;

    public GameConstructor(int width, int height, StateCoordinator coordinator) throws InterruptedException {
        this.coordinator = coordinator;
        table = new Table(width, height);
        generator = new PieceGenerator(new Random(), width);
        tetris = new TetrisLogic(table, generator);
        kpl = new KeyPressListener(coordinator, this.coordinator.getKeyConfigurer().getKeys());
        renderer = new MyFirstRenderer(tetris, coordinator.getStartingScreen().getScale());
        gameScreen = new GameScreen(width, height, coordinator.getStartingScreen().getScale(), renderer, kpl, coordinator);
        renderLoop = new MyRenderLoop(renderer, tetris);
        gameLoop = new MyGameLoop(kpl, tetris);        
    }

    public MyGameLoop getGameLoop() {
        return gameLoop;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public PieceGenerator getGenerator() {
        return generator;
    }

    public KeyPressListener getKpl() {
        return kpl;
    }

    public MyRenderLoop getRenderLoop() {
        return renderLoop;
    }

    public MyFirstRenderer getRenderer() {
        return renderer;
    }

    public Table getTable() {
        return table;
    }

    public TetrisLogic getTetris() {
        return tetris;
    }
    
    
    
    public void createAndStartGame() throws InterruptedException {  
        this.table.setTable(this.coordinator.getStartingScreen().getWidth(), this.coordinator.getStartingScreen().getHeight());
        this.generator.setTableWidth(this.coordinator.getStartingScreen().getWidth());
        this.renderer.setScale(this.coordinator.getStartingScreen().getScale());
        gameScreen.start();
        Thread.sleep(1000);
        this.gameScreen.setScale(this.coordinator.getStartingScreen().getScale());
        this.gameScreen.setWidth(this.coordinator.getStartingScreen().getWidth());
        this.gameScreen.setHeight(this.coordinator.getStartingScreen().getHeight());
        this.gameScreen.getFrame().setVisible(true);
        renderLoop.start();
        this.coordinator.getStartingScreen().getFrame().setVisible(false);
        gameLoop.createThreadAndStart();
    }
    
    public void startGame() {
        this.coordinator.getStartingScreen().getFrame().setVisible(false);        
        this.gameScreen.setScale(this.coordinator.getStartingScreen().getScale());
        this.gameScreen.setWidth(this.coordinator.getStartingScreen().getWidth());
        this.gameScreen.setHeight(this.coordinator.getStartingScreen().getHeight());
        this.gameScreen.resizeFrame();
        this.gameScreen.getFrame().setVisible(true);
        this.tetris.setTable(this.coordinator.getStartingScreen().getWidth(), this.coordinator.getStartingScreen().getHeight());
        this.generator.setTableWidth(this.coordinator.getStartingScreen().getWidth());
        this.tetris.restart();
    }
}