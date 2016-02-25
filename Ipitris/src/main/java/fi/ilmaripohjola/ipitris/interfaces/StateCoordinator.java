package fi.ilmaripohjola.ipitris.interfaces;

import fi.ilmaripohjola.ipitris.gamelogic.TetrisLogic;
import fi.ilmaripohjola.ipitris.gameloop.MyGameLoop;
import fi.ilmaripohjola.ipitris.gameloop.MyRenderLoop;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Coordinates between different phases in program. Implements ActionListener.
 *
 * @author omistaja
 */
public class StateCoordinator implements ActionListener {
    
    private StartingScreen startingScreen;
    private SliderCoordinator sliderCoordinator;
    private KeyConfigurer keyConfigurer;
    private GameConstructor constructor;

    /**
     * Creates new StartingScreen and SliderCoordinator with which to
     * communicate.
     *
     * @throws InterruptedException
     */
    public StateCoordinator() throws InterruptedException {
        this.startingScreen = new StartingScreen(this);
        this.sliderCoordinator = new SliderCoordinator(this.startingScreen);
        this.keyConfigurer = this.startingScreen.getKeyConfigurer();
        this.constructor = new GameConstructor(startingScreen.getWidth(), startingScreen.getHeight(), this);
    }

    public TetrisLogic getTetris() {
        return this.constructor.getTetris();
    }

    public SliderCoordinator getSliderCoordinator() {
        return sliderCoordinator;
    }

    public MyGameLoop getGameLoop() {
        return this.constructor.getGameLoop();
    }

    public KeyConfigurer getKeyConfigurer() {
        return keyConfigurer;
    }

    public GameConstructor getConstructor() {
        return constructor;
    }

    public MyRenderLoop getRenderLoop() {
        return this.constructor.getRenderLoop();
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
        } else if (e.getActionCommand().equals("OPTIONS")) {
            showOptionsPanel();
        } else if (e.getActionCommand().equals("CONFIRM")) {
            showStartPanel();
        } else if (e.getActionCommand().equals("BOARD OPTIONS")) {
            showBoardPanel();
        } else if (e.getActionCommand().equals("BACK")) {
            showOptionsPanel();
        } else if (e.getActionCommand().equals("BACK TO VISUAL OPTIONS")) {
            this.showVisualPanel();
        } else if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("VISUAL OPTIONS")) {
            showVisualPanel();
        } else if (e.getActionCommand().equals("PAUSE")) {
            if (this.constructor.getTetris().getContinues()) {
                this.constructor.getTetris().pause();
            } else {
                this.constructor.getTetris().unPause();
            }
        } else if (e.getActionCommand().equals("RESTART")) {
            this.constructor.getTetris().restart();
        } else if (e.getActionCommand().equals("QUIT")) {
            this.constructor.getTetris().endGame();
            this.constructor.getGameScreen().getFrame().setVisible(false);
            this.startingScreen.getFrame().setVisible(true);
        } else if (e.getActionCommand().equals("KEY OPTIONS")) {
            showKeyPanel();
        } else if (e.getActionCommand().equals("COLORS")) {
            showColorsPanel();
        }
        if (e.getActionCommand().equals("DOWN")) {
            this.startingScreen.setKeyToConfigure(0);
            this.setKeyButtonRed(0);
        }
        if (e.getActionCommand().equals("LEFT")) {
            this.startingScreen.setKeyToConfigure(1);
            this.setKeyButtonRed(1);
        }
        if (e.getActionCommand().equals("RIGHT")) {
            this.startingScreen.setKeyToConfigure(2);
            this.setKeyButtonRed(2);
        }
        if (e.getActionCommand().equals("ROTATE")) {
            this.startingScreen.setKeyToConfigure(3);
            this.setKeyButtonRed(3);
        } else {
            JPanel cp = (JPanel) startingScreen.getFrame().getContentPane().getComponent(4);
            JColorChooser jcc = (JColorChooser) cp.getComponent(1);
            Color color = jcc.getColor();
            if (e.getActionCommand().equals("I")) {
                this.constructor.getGenerator().setColor(color, 0);
                this.setPieceButtonColor(0, color);
            }
            if (e.getActionCommand().equals("T")) {
                this.constructor.getGenerator().setColor(color, 1);
                this.setPieceButtonColor(1, color);
            }
            if (e.getActionCommand().equals("Square")) {
                this.constructor.getGenerator().setColor(color, 2);
                this.setPieceButtonColor(2, color);
            }
            if (e.getActionCommand().equals("L")) {
                this.constructor.getGenerator().setColor(color, 3);
                this.setPieceButtonColor(3, color);
            }
            if (e.getActionCommand().equals("J")) {
                this.constructor.getGenerator().setColor(color, 4);
                this.setPieceButtonColor(4, color);
            }
            if (e.getActionCommand().equals("S")) {
                this.constructor.getGenerator().setColor(color, 5);
                this.setPieceButtonColor(5, color);
            }
            if (e.getActionCommand().equals("Z")) {
                this.constructor.getGenerator().setColor(color, 6);
                this.setPieceButtonColor(6, color);
            }
        }

    }

    private void startGame() throws InterruptedException {
        if (this.constructor.getGameScreen().getFrame() == null) {
            this.constructor.createAndStartGame();
        } else {
            this.constructor.startGame();
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

    private void showColorsPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "colorPanel");
    }

    private void showPreviousPanel() {
        JFrame frame = startingScreen.getFrame();
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.previous(frame.getContentPane());
    }

    private void showKeyPanel() {
        CardLayout cl = (CardLayout) startingScreen.getFrame().getContentPane().getLayout();
        cl.show(startingScreen.getFrame().getContentPane(), "keyPanel");
    }

    /**
     * Currently unimplemented method.
     */
    public void makeSound() {

    }

}
