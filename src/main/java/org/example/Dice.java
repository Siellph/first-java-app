package org.example;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class Dice {
    private static final RandomGenerator random = RandomGeneratorFactory.of("Random").create();
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void sayHello(JTextArea textArea, String username) {
        appendMessage(textArea, String.format("Привет, %s!", username));
    }

    public static void rollDice(JTextArea textArea, String username, int sides) {
        int randomNumber = random.nextInt(sides) + 1; // Генерация случайного числа в диапазоне от 1 до sides
        String currentTime = LocalTime.now().format(timeFormatter);
        appendMessage(textArea, String.format("%s. Бросаю D%d. %s, выпало %d", currentTime, sides, username, randomNumber));
    }

    public static void exitProgram(JTextArea textArea) {
        appendMessage(textArea, "Завершение программы...");
    }

    private static void appendMessage(JTextArea textArea, String message) {
        textArea.append(message + "\n");
    }
}
