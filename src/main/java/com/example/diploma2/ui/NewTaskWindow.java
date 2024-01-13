// NewTaskWindow.java
package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTaskWindow extends JFrame {
    private JTextField taskNameField;
    private JTextField taskValueField;
    private JTextField taskCostField;
    private JButton addButton;

    public NewTaskWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Додати нову задачу");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Назва задачі:");
        JLabel valueLabel = new JLabel("Значення:");
        JLabel costLabel = new JLabel("Вартість:");

        taskNameField = new JTextField();
        taskValueField = new JTextField();
        taskCostField = new JTextField();

        addButton = new JButton("Додати");

        mainPanel.add(nameLabel);
        mainPanel.add(taskNameField);
        mainPanel.add(valueLabel);
        mainPanel.add(taskValueField);
        mainPanel.add(costLabel);
        mainPanel.add(taskCostField);
        mainPanel.add(addButton);

        add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameField.getText();
                String taskValue = taskValueField.getText();
                String taskCost = taskCostField.getText();

                // Додайте код для збереження нової задачі в базу даних
                // і оновлення списку завдань

                JOptionPane.showMessageDialog(NewTaskWindow.this, "Задачу додано!");
                dispose(); // Закриваємо вікно після додавання задачі
            }
        });
    }
}
