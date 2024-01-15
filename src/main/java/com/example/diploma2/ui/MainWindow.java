
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

        prioritizationMethodComboBox = new JComboBox<>(new String[]{"RICE", "Kano", "Pugh", "2x2 Matrix"});
        prioritizeButton = new JButton("Вибрати метод пріоритету");

        //viewListsButton = new JButton("Подивитись списки");

        mainPanel.add(prioritizationMethodComboBox);
        mainPanel.add(prioritizeButton);
        //mainPanel.add(viewListsButton);

        add(mainPanel);

//        prioritizeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedMethod = (String) prioritizationMethodComboBox.getSelectedItem();
//                if ("Цінність проти витрат".equals(selectedMethod)) {
//                    // Додайте код для обробки пріоритезації за методом "Цінність проти витрат"
//                    JOptionPane.showMessageDialog(MainWindow.this, "Обробка методу 'Цінність проти витрат'");
//                } else if ("Інший метод пріоритезації".equals(selectedMethod)) {
//                    // Додайте код для обробки іншого методу пріоритету, якщо потрібно
//                    JOptionPane.showMessageDialog(MainWindow.this, "Обробка іншого методу пріоритету");
//                }
//            }
//        });

        prioritizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMethod = (String) prioritizationMethodComboBox.getSelectedItem();
                if ("RICE".equals(selectedMethod)) {
                    // Відкриваємо вікно для методу RICE
                    openRiceMethodWindow();
                } else if ("Kano".equals(selectedMethod)) {
                    // Відкриваємо вікно для методу Kano
                    openKanoMethodWindow();
                } else if ("Pugh".equals(selectedMethod)) {
                    // Відкриваємо вікно для методу Pugh
                    openPughMethodWindow();
                } else if ("2x2 Matrix".equals(selectedMethod)) {
                    // Відкриваємо вікно для методу 2x2 Matrix
                    openTwoByTwoMatrixMethodWindow();
                } else if ("value over cost".equals(selectedMethod)) {
                    // Відкриваємо вікно для методу value over cost
                    openValueOverCostMethodWindow();
                }
            }
        });

//        viewListsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Додайте код для переходу до списків задач або їх перегляду
//                JOptionPane.showMessageDialog(MainWindow.this, "Перехід до списків задач або їх перегляд");
//            }
//        });
    }

    private void openRiceMethodWindow() {
        // Створіть та відкрийте вікно для методу RICE
        RiceMethodWindow riceMethodWindow = new RiceMethodWindow();
        riceMethodWindow.setVisible(true);
    }
    private void openKanoMethodWindow() {
        KanoMethodWindow kanoMethodWindow = new KanoMethodWindow();
        kanoMethodWindow.setVisible(true);
    }
    private void openPughMethodWindow() {
        PughMethodWindow pughMethodWindow = new PughMethodWindow();
        pughMethodWindow.setVisible(true);
    }
    private void openTwoByTwoMatrixMethodWindow() {
        TwoByTwoMatrixMethodWindow twoByTwoMatrixMethodWindow = new TwoByTwoMatrixMethodWindow();
        twoByTwoMatrixMethodWindow.setVisible(true);
    }
    private void openValueOverCostMethodWindow() {
        ValueOverCostMethodWindow valueOverCostMethodWindow = new ValueOverCostMethodWindow();
        valueOverCostMethodWindow.setVisible(true);
    }

}
