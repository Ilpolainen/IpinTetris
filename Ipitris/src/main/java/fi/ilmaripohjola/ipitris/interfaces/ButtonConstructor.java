/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class ButtonConstructor {

    public ButtonConstructor() {
    }

    public void createButtons(PanelNavigator panelNavigator, StateCoordinator stateCoordinator, JPanel[] panels) {
        this.createPanelNavigatorButtons(panels, panelNavigator);
        this.createOtherButtons(panels, stateCoordinator);
    }

    private void createPanelNavigatorButtons(JPanel[] panels, PanelNavigator panelNavigator) {
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

    private void createOtherButtons(JPanel[] panels, StateCoordinator stateCoordinator) {
        JButton start = new JButton("START");
        JButton trash = new JButton("TRASH");
        JButton exit = new JButton("EXIT");
        JButton down = new JButton("DOWN");
        JButton left = new JButton("LEFT");
        JButton right = new JButton("RIGHT");
        JButton rotate = new JButton("ROTATE");
        connectOtherButtons(stateCoordinator, start, trash, exit, down, left, right, rotate);
        attachOtherButtons(panels, start, trash, exit, down, left, right, rotate);
    }

    private void connectPanelNavigatorButtons(PanelNavigator panelNavigator, JButton options, JButton confirm, JButton visualOptions, JButton boardOptions, JButton back, JButton back2, JButton colors, JButton keys, JButton back3, JButton backToVisualOptions) {
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

    private void connectOtherButtons(StateCoordinator stateCoordinator, JButton start, JButton trash, JButton exit, JButton down, JButton left, JButton right, JButton rotate) {
        start.addActionListener(stateCoordinator);
        exit.addActionListener(stateCoordinator);
        trash.addActionListener(stateCoordinator);
        down.addActionListener(stateCoordinator);
        left.addActionListener(stateCoordinator);
        right.addActionListener(stateCoordinator);
        rotate.addActionListener(stateCoordinator);
    }

    private void attachPanelNavigatorButtons(JPanel[] panels, JButton options, JButton confirm, JButton visualOptions, JButton boardOptions, JButton back, JButton back2, JButton colors, JButton keys, JButton back3, JButton backToVisualOptions) {
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

    private void attachOtherButtons(JPanel[] panels, JButton start, JButton trash, JButton exit, JButton down, JButton left, JButton right, JButton rotate) {
        panels[0].add(start, 0);
        panels[0].add(trash);
        panels[0].add(exit);
        JPanel buttons = new JPanel();
        buttons.add(down);
        buttons.add(left);
        buttons.add(right);
        buttons.add(rotate);
        panels[5].add(buttons);
    }
}
