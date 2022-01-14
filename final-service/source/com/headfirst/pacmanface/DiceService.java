package com.headfirst.pacmanface;

import java.awt.event.*;
import javax.swing.*;

public class DiceService implements MyService {

    JLabel label;
    JComboBox<String> numOfDice;

    @Override
    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll `em!");
        String[] choices = {"1","2","3","4","5"};
        numOfDice = new JComboBox<>(choices);
        label = new JLabel("dice values here");
        button.addActionListener(new RollEmListener());
        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    }

    public class RollEmListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String diceOutput = "";
            String userSelect = (String) numOfDice.getSelectedItem();
            int numOfDiceToRoll = Integer.parseInt(userSelect);
            for (int i = 0; i < numOfDiceToRoll; i++) {
                int r = (int) ((Math.random()*6)+1);
                diceOutput += (" "+r);
            }
            label.setText(diceOutput);
        }
    }
}
