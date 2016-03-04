package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.Logic;
import fi.ilmaripohjola.ipitris.gameloop.UpdateLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyRenderLoop;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 * Coordinates between different phases in program. Implements ActionListener.
 *
 * @author omistaja
 */
public class StateCoordinator implements ActionListener {

    private StartingScreen startingScreen;
    private KeyConfigurer keyConfigurer;
    private GameCenterUnit gameCenterUnit;

    /**
     * Creates new StartingScreen and SliderCoordinator with which to
     * communicate.
     *
     * @throws InterruptedException
     */
    public StateCoordinator() throws InterruptedException {
        this.startingScreen = new StartingScreen(this);
        this.keyConfigurer = this.startingScreen.getKeyConfigurer();
        this.gameCenterUnit = new GameCenterUnit(startingScreen.getWidth(), startingScreen.getHeight(), this);
    }

    public Logic getTetris() {
        return this.gameCenterUnit.getTetris();
    }

    public UpdateLoop getGameLoop() {
        return this.gameCenterUnit.getGameLoop();
    }

    public KeyConfigurer getKeyConfigurer() {
        return keyConfigurer;
    }

    public GameCenterUnit getConstructor() {
        return gameCenterUnit;
    }

    public MyRenderLoop getRenderLoop() {
        return this.gameCenterUnit.getRenderLoop();
    }

    public StartingScreen getStartingScreen() {
        return startingScreen;
    }

    /**
     * Calls start() method for the current class variable StartingScreen.
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {
        startingScreen.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("START")) {
            try {
                startGame();
            } catch (InterruptedException ex) {
                Logger.getLogger(StateCoordinator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getActionCommand().equals("TRASH")) {
            makeSound();
        } else if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("PAUSE")) {
            if (this.gameCenterUnit.getTetris().getContinues()) {
                this.gameCenterUnit.getTetris().pause();
            } else {
                this.gameCenterUnit.getTetris().unPause();
            }
        } else if (e.getActionCommand().equals("RESTART")) {
            this.gameCenterUnit.getTetris().start();
        } else if (e.getActionCommand().equals("QUIT")) {
            this.gameCenterUnit.getTetris().endGame();
            this.gameCenterUnit.getGameScreen().getFrame().setVisible(false);
            this.startingScreen.getFrame().setVisible(true);
        } else if (e.getActionCommand().equals("DOWN")) {
            this.startingScreen.setKeyToConfigure(0);
            this.setKeyButtonRed(0);
        } else if (e.getActionCommand().equals("LEFT")) {
            this.startingScreen.setKeyToConfigure(1);
            this.setKeyButtonRed(1);
        } else if (e.getActionCommand().equals("RIGHT")) {
            this.startingScreen.setKeyToConfigure(2);
            this.setKeyButtonRed(2);
        } else if (e.getActionCommand().equals("ROTATE")) {
            this.startingScreen.setKeyToConfigure(3);
            this.setKeyButtonRed(3);
        } else {
            JPanel cp = (JPanel) startingScreen.getFrame().getContentPane().getComponent(4);
            JColorChooser jcc = (JColorChooser) cp.getComponent(1);
            Color color = jcc.getColor();
            if (e.getActionCommand().equals("I")) {
                this.gameCenterUnit.getGenerator().setColor(color, 0);
                this.setPieceButtonColor(0, color);
            } else if (e.getActionCommand().equals("T")) {
                this.gameCenterUnit.getGenerator().setColor(color, 1);
                this.setPieceButtonColor(1, color);
            } else if (e.getActionCommand().equals("Square")) {
                this.gameCenterUnit.getGenerator().setColor(color, 2);
                this.setPieceButtonColor(2, color);
            } else if (e.getActionCommand().equals("L")) {
                this.gameCenterUnit.getGenerator().setColor(color, 3);
                this.setPieceButtonColor(3, color);
            } else if (e.getActionCommand().equals("J")) {
                this.gameCenterUnit.getGenerator().setColor(color, 4);
                this.setPieceButtonColor(4, color);
            } else if (e.getActionCommand().equals("S")) {
                this.gameCenterUnit.getGenerator().setColor(color, 5);
                this.setPieceButtonColor(5, color);
            } else if (e.getActionCommand().equals("Z")) {
                this.gameCenterUnit.getGenerator().setColor(color, 6);
                this.setPieceButtonColor(6, color);
            }
        }

    }

    private void startGame() throws InterruptedException {
        if (this.gameCenterUnit.getGameScreen().getFrame() == null) {
            this.gameCenterUnit.createAndStartGame();
        } else {
            this.gameCenterUnit.startGame();
        }
    }

    private void setPieceButtonColor(int i, Color color) {
        JPanel keyPanel = (JPanel) this.startingScreen.getFrame().getContentPane().getComponent(4);
        JPanel buttons = (JPanel) keyPanel.getComponent(0);
        JButton button = (JButton) buttons.getComponent(i);
        if (color == keyPanel.getBackground()) {
            button.setForeground(color);
        } else {
            button.setForeground(Color.BLACK);
            button.setBackground(color);
        }

    }

    private void setKeyButtonRed(int i) {
        JPanel keyPanel = (JPanel) this.startingScreen.getFrame().getContentPane().getComponent(5);
        JPanel buttons = (JPanel) keyPanel.getComponent(1);
        clearButtonColors(buttons);
        JButton button = (JButton) buttons.getComponent(i);
        button.setForeground(Color.red);
    }

    private void clearButtonColors(JPanel panel) {
        for (int j = 0; j < panel.getComponentCount(); j++) {
            JButton buttonToClear = (JButton) panel.getComponent(j);
            buttonToClear.setForeground(Color.BLACK);
        }
    }

    /**
     * Currently unimplemented method.
     */
    public void makeSound() {

    }

}
