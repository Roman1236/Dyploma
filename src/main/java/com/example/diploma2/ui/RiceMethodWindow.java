package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiceMethodWindow extends JFrame {
    private JTextField nameField;
    private JTextField reachField;
    private JTextField impactField;
    private JTextField confidenceField;
    private JTextField effortField;
    private JButton calculateButton;

    public RiceMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Метод RICE");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Назва завдання:");
        JLabel reachLabel = new JLabel("Reach:");
        JLabel impactLabel = new JLabel("Impact:");
        JLabel confidenceLabel = new JLabel("Confidence:");
        JLabel effortLabel = new JLabel("Effort:");

        nameField = new JTextField();
        reachField = new JTextField();
        impactField = new JTextField();
        confidenceField = new JTextField();
        effortField = new JTextField();
        calculateButton = new JButton("Розрахувати RICE Score");

        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(reachLabel);
        mainPanel.add(reachField);
        mainPanel.add(impactLabel);
        mainPanel.add(impactField);
        mainPanel.add(confidenceLabel);
        mainPanel.add(confidenceField);
        mainPanel.add(effortLabel);
        mainPanel.add(effortField);
        mainPanel.add(new JLabel(""));
        mainPanel.add(calculateButton);

        add(mainPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримати дані з полів введення
                String name = nameField.getText();
                double reach = Double.parseDouble(reachField.getText());
                double impact = Double.parseDouble(impactField.getText());
                double confidence = Double.parseDouble(confidenceField.getText());
                double effort = Double.parseDouble(effortField.getText());

                // Розрахувати RICE Score
                double riceScore = (reach * impact * confidence) / effort;

                // Відобразити результат
                JOptionPane.showMessageDialog(RiceMethodWindow.this,
                        "Результат для завдання '" + name + "':\nRICE Score = " + riceScore,
                        "Результат",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
