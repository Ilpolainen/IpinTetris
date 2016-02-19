package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.entities.Table;
import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gamelogic.PieceGenerator;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyRenderLoop;
import fi.ilmaripohjola.ipitris.utilities.MyFirstRenderer;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;

/**
 * Coordinates between different phases in program. Implements ActionListener.
 * @author omistaja
 */
public class StateCoordinator implements ActionListener {

    private MyRenderLoop renderLoop;
    private MyGameLoop gameLoop;
    private StartingScreen startingScreen;
    private SliderCoordinator sliderCoordinator;
    private GameScreen gameScreen;
    private PieceGenerator generator;
    private Table table;
    private TetrisLogic tetris;
    private KeyPressListener kpl;
    private MyFirstRenderer renderer;

    /**
     * Creates new StartingScreen and SliderCoordinator with which to communicate.
     * @throws InterruptedException 
     */
    
    public StateCoordinator() throws InterruptedException {
        this.startingScreen = new StartingScreen(this);
        this.sliderCoordinator = new SliderCoordinator(this.startingScreen);
        gameLoop = null;
        renderLoop = null;
    }

    public SliderCoordinator getSliderCoordinator() {
        return sliderCoordinator;
    }

    public MyGameLoop getGameLoop() {
        return gameLoop;
    }

    public MyRenderLoop getRenderLoop() {
        return renderLoop;
    }

    public StartingScreen getStartingScreen() {
        return startingScreen;
    }

    /**
     * Calls start() method for the current class variable StartingScreen. 
     * @throws InterruptedException 
     */
    
    public void start() throws InterruptedException {
        startingScreen.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {
            try {
                setUpGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(StateCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getActionCommand().equals("TRASH")) {
            makeSound();
        }
        if (e.getActionCommand().equals("OPTIONS")) {
            showOptionsPanel();
        }
        if (e.getActionCommand().equals("CONFIRM")) {
            showStartPanel();
        }
        if (e.getActionCommand().equals("BOARD OPTIONS")) {
            showBoardPanel();
        }
        if (e.getActionCommand().equals("BACK")) {
            showOptionsPanel();
        }
        if (e.getActionCommand().equals("QUIT")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("VISUAL OPTIONS")) {
            showVisualPanel();
        }
    }

    private void setUpGame() throws InterruptedException {
        int width = startingScreen.getWidth();
        int height = startingScreen.getHeight();
        System.out.println(width);
        System.out.println(height);
        table = new Table(width, height);
        generator = new PieceGenerator(new Random(), width);
        tetris = new TetrisLogic(table, generator);
        kpl = new KeyPressListener(this);
        renderer = new MyFirstRenderer(tetris, startingScreen.getScale());
        gameScreen = new GameScreen(width, height, startingScreen.getScale(), renderer, kpl);
        renderLoop = new MyRenderLoop(renderer, tetris);
        gameLoop = new MyGameLoop(kpl, tetris);
        gameScreen.start();
        renderLoop.start();
        startingScreen.getFrame().setVisible(false);
        gameLoop.start();
    }

    private void setColors() {
        //HAE TÄSSÄ VÄRIT
//        this.generator.setColors(Color.red, Color.blue, Color.red, Color.red, Color.red, Color.red, Color.red);
    }

    private void showStartPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "startPanel");
    }

    private void showOptionsPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "optionsPanel");
    }

    private void showBoardPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "boardPanel");
    }

    private void showVisualPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "visualOptionsPanel");
    }
    
    /**
     * Currently unimplemented method.
     */

    public void makeSound() {
        
    }

}
