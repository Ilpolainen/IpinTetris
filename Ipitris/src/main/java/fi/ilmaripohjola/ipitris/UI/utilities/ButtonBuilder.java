/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.UI.utilities;

import fi.ilmaripohjola.ipitris.UI.PanelNavigator;
import fi.ilmaripohjola.ipitris.application.logic.actions.ApplicationCommand;
import fi.ilmaripohjola.ipitris.gamelogic.commands.GameCommand;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class ButtonBuilder {

    public static void createButtons(PanelNavigator panelNavigator, ActionListener application, ActionListener keyConfigurer, JPanel[] panels) {
        ButtonBuilder.createPanelNavigatorButtons(panels, panelNavigator);
        ButtonBuilder.createApplicationButtons(panels, application);
        ButtonBuilder.createKeyConfigureButtons(panels, keyConfigurer);
    }

    private static void createPanelNavigatorButtons(JPanel[] panels, PanelNavigator panelNavigator) {
        JButton options = new JButton("OPTIONS");
        JButton confirm = new JButton("CONFIRM");
        JButton boardOptions = new JButton("BOARD OPTIONS");
        JButton visualOptions = new JButton("VISUAL OPTIONS");
        JButton back = new JButton("BACK");
        JButton back2 = new JButton("BACK");
        JButton colors = new JButton("COLORS");
        JButton keys = new JButton("KEY OPTIONS");
        JButton back3 = new JButton("BACK");
        JButton backToVisualOptions = new JButton("BACK TO VISUAL OPTIONS");
        connectPanelNavigatorButtons(panelNavigator, options, confirm, visualOptions, boardOptions, back, back2, colors, keys, back3, backToVisualOptions);
        attachPanelNavigatorButtons(panels, options, confirm, boardOptions, visualOptions, back, back2, colors, keys, back3, backToVisualOptions);
    }

    private static void createApplicationButtons(JPanel[] panels, ActionListener application) {
        JButton start = new JButton("START");
        start.setActionCommand(ApplicationCommand.START_GAME.toString());
        JButton exit = new JButton("EXIT");
        exit.setActionCommand(ApplicationCommand.EXIT_APPLICATION.toString());
        ButtonBuilder.connectApplicationButtons(application, start, exit);
        ButtonBuilder.attachApplicationButtons(panels, start, exit);
    }

    private static void connectPanelNavigatorButtons(PanelNavigator panelNavigator, JButton options, JButton confirm, JButton visualOptions, JButton boardOptions, JButton back, JButton back2, JButton colors, JButton keys, JButton back3, JButton backToVisualOptions) {
        options.addActionListener(panelNavigator);
        confirm.addActionListener(panelNavigator);
        boardOptions.addActionListener(panelNavigator);
        back.addActionListener(panelNavigator);
        visualOptions.addActionListener(panelNavigator);
        back2.addActionListener(panelNavigator);
        colors.addActionListener(panelNavigator);
        keys.addActionListener(panelNavigator);
        back3.addActionListener(panelNavigator);
        backToVisualOptions.addActionListener(panelNavigator);
    }

    private static void createKeyConfigureButtons(JPanel[] panels, ActionListener keyConfigurer) {
        JButton down = new JButton("DOWN");
        down.setActionCommand(GameCommand.DOWN.toString());
        JButton left = new JButton("LEFT");
        left.setActionCommand(GameCommand.LEFT.toString());
        JButton right = new JButton("RIGHT");
        right.setActionCommand(GameCommand.RIGHT.toString());
        JButton rotate = new JButton("ROTATE");
        rotate.setActionCommand(GameCommand.ROTATE.toString());
        ButtonBuilder.connectKeyConfigureButtons(keyConfigurer, down, left, right, rotate);
        ButtonBuilder.attachKeyConfigureButtons(panels, down, left, right, rotate);
    }
    
    private static void connectKeyConfigureButtons(ActionListener keyConfigurer,JButton down, JButton left, JButton right, JButton rotate) {
        down.addActionListener(keyConfigurer);
        left.addActionListener(keyConfigurer);
        right.addActionListener(keyConfigurer);
        rotate.addActionListener(keyConfigurer);
    }
    
    private static void attachKeyConfigureButtons(JPanel[] panels,JButton down, JButton left, JButton right, JButton rotate) {
        JPanel buttons = new JPanel();
        buttons.add(down);
        buttons.add(left);
        buttons.add(right);
        buttons.add(rotate);
        panels[5].add(buttons);
    }
    
    private static void connectApplicationButtons(ActionListener application, JButton start, JButton exit) {
        start.addActionListener(application);
        exit.addActionListener(application);
    }

    private static void attachPanelNavigatorButtons(JPanel[] panels, JButton options, JButton confirm, JButton visualOptions, JButton boardOptions, JButton back, JButton back2, JButton colors, JButton keys, JButton back3, JButton backToVisualOptions) {
        panels[0].add(options);
        panels[1].add(confirm);
        panels[1].add(boardOptions);
        panels[1].add(visualOptions);
        panels[1].add(keys);
        panels[2].add(back);
        panels[3].add(back2);
        panels[3].add(colors);
        panels[4].add(backToVisualOptions, BorderLayout.NORTH);
        panels[5].add(back3);
    }

    private static void attachApplicationButtons(JPanel[] panels, JButton start, JButton exit) {
        panels[0].add(start,0);
        panels[0].add(exit);
    }
}
