package org.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static JTextArea textArea;
    private static String username;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Dice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 250));

        JPanel buttonPanel = getjPanel();

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // Запрос имени пользователя при запуске
        username = JOptionPane.showInputDialog("Введите ваше имя:");
        if (username == null || username.isEmpty()) {
            username = "User";
        }
    }

    private static JPanel getjPanel() {
        JButton helloButton = new JButton("Hello");
        helloButton.addActionListener(_ -> Dice.sayHello(textArea, username));

        JButton dice4 = new JButton("D4");
        dice4.addActionListener(_ -> Dice.rollDice(textArea, username, 4));

        JButton dice6 = new JButton("D6");
        dice6.addActionListener(_ -> Dice.rollDice(textArea, username, 6));

        JButton dice8 = new JButton("D8");
        dice8.addActionListener(_ -> Dice.rollDice(textArea, username, 8));

        JButton dice10 = new JButton("D10");
        dice10.addActionListener(_ -> Dice.rollDice(textArea, username, 10));

        JButton dice12 = new JButton("D12");
        dice12.addActionListener(_ -> Dice.rollDice(textArea, username, 12));

        JButton dice20 = new JButton("D20");
        dice20.addActionListener(_ -> Dice.rollDice(textArea, username, 20));

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(_ -> {
            Dice.exitProgram(textArea);
            System.exit(0);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(helloButton);
        buttonPanel.add(dice4);
        buttonPanel.add(dice6);
        buttonPanel.add(dice8);
        buttonPanel.add(dice10);
        buttonPanel.add(dice12);
        buttonPanel.add(dice20);
        buttonPanel.add(exitButton);
        return buttonPanel;
    }
}
