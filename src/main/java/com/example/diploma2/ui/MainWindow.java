// MainWindow.java
package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JComboBox<String> prioritizationMethodComboBox;
    private JButton prioritizeButton;
    private JButton viewListsButton;

    public MainWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Task Prioritization App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        prioritizationMethodComboBox = new JComboBox<>(new String[]{"Цінність проти витрат", "Інший метод пріоритезації"});
        prioritizeButton = new JButton("Пріоритезувати");
        viewListsButton = new JButton("Подивитись списки");

        mainPanel.add(prioritizationMethodComboBox);
        mainPanel.add(prioritizeButton);
        mainPanel.add(viewListsButton);

        add(mainPanel);

        prioritizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMethod = (String) prioritizationMethodComboBox.getSelectedItem();
                if ("Цінність проти витрат".equals(selectedMethod)) {
                    // Додайте код для обробки пріоритезації за методом "Цінність проти витрат"
                    JOptionPane.showMessageDialog(MainWindow.this, "Обробка методу 'Цінність проти витрат'");
                } else if ("Інший метод пріоритезації".equals(selectedMethod)) {
                    // Додайте код для обробки іншого методу пріоритету, якщо потрібно
                    JOptionPane.showMessageDialog(MainWindow.this, "Обробка іншого методу пріоритету");
                }
            }
        });

        viewListsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Додайте код для переходу до списків задач або їх перегляду
                JOptionPane.showMessageDialog(MainWindow.this, "Перехід до списків задач або їх перегляд");
            }
        });
    }
}
