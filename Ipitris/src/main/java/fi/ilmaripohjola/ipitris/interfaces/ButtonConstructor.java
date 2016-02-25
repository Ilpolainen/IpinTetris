/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ilmaripohjola.ipitris.interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author omistaja
 */
public class ButtonConstructor {

    public ButtonConstructor() {
    }

    public void createButtons(StateCoordinator stateCoordinator, JPanel[] panels) {
        JButton start = new JButton("START");
        JButton options = new JButton("OPTIONS");
        JButton trash = new JButton("TRASH");
        JButton exit = new JButton("EXIT");
        JButton confirm = new JButton("CONFIRM");
        JButton boardOptions = new JButton("BOARD OPTIONS");
        JButton visualOptions = new JButton("VISUAL OPTIONS");
        JButton back = new JButton("BACK");
        JButton back2 = new JButton("BACK");
        JButton colors = new JButton("COLORS");
        JButton keys = new JButton("KEY OPTIONS");
        JButton down = new JButton("DOWN");
        JButton left = new JButton("LEFT");
        JButton right = new JButton("RIGHT");
        JButton rotate = new JButton("ROTATE");
        JButton back3 = new JButton("BACK");
        attachButtons(panels, start, options, trash, exit, confirm, boardOptions, back, visualOptions, back2, colors, keys, down, left, right, rotate, back3);
        connectButtons(stateCoordinator, start, options, trash, exit, confirm, boardOptions, back, visualOptions, back2, colors, keys, down, left, right, rotate, back3);
    }

    public void attachButtons(JPanel[] panels, JButton start, JButton options, JButton trash, JButton exit, JButton confirm, JButton boardOptions, JButton back, JButton visualOptions, JButton back2, JButton colors, JButton keys, JButton down, JButton left, JButton right, JButton rotate, JButton back3) {
        panels[1].add(confirm);
        panels[1].add(boardOptions);
        panels[1].add(visualOptions);
        panels[1].add(keys);
        panels[0].add(start);
        panels[0].add(options);
        panels[0].add(trash);
        panels[0].add(exit);
        panels[2].add(back);
        panels[3].add(back2);
        panels[3].add(colors);
        JPanel buttons = new JPanel();
        buttons.add(down);
        buttons.add(left);
        buttons.add(right);
        buttons.add(rotate);
        panels[5].add(back3);
        panels[5].add(buttons);
    }

    public void connectButtons(StateCoordinator stateCoordinator, JButton start, JButton options, JButton trash, JButton exit, JButton confirm, JButton boardOptions, JButton back, JButton visualOptions, JButton back2, JButton colors, JButton buttons, JButton down, JButton left, JButton right, JButton rotate, JButton back3) {
        start.addActionListener(stateCoordinator);
        exit.addActionListener(stateCoordinator);
        trash.addActionListener(stateCoordinator);
        options.addActionListener(stateCoordinator);
        confirm.addActionListener(stateCoordinator);
        boardOptions.addActionListener(stateCoordinator);
        back.addActionListener(stateCoordinator);
        visualOptions.addActionListener(stateCoordinator);
        back2.addActionListener(stateCoordinator);
        colors.addActionListener(stateCoordinator);
        buttons.addActionListener(stateCoordinator);
        down.addActionListener(stateCoordinator);
        left.addActionListener(stateCoordinator);
        right.addActionListener(stateCoordinator);
        rotate.addActionListener(stateCoordinator);
        back3.addActionListener(stateCoordinator);
    }
}
