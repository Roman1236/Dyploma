package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoByTwoMatrixMethodWindow extends JFrame {
    private JTextField nameField;
    private JTextField effortField;
    private JTextField valueField;
    private JTextArea resultTextArea;
    private JButton calculateButton;

    public TwoByTwoMatrixMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("2x2 Matrix Method");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Create labels and fields for task name, effort, and value
        JLabel nameLabel = new JLabel("Task Name:");
        nameField = new JTextField();
        JLabel effortLabel = new JLabel("Effort:");
        effortField = new JTextField();
        JLabel valueLabel = new JLabel("Value:");
        valueField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(effortLabel);
        inputPanel.add(effortField);
        inputPanel.add(valueLabel);
        inputPanel.add(valueField);

        calculateButton = new JButton("Calculate Priority");
        inputPanel.add(new JLabel("")); // Empty label for spacing
        inputPanel.add(calculateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Create and configure the result text area
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        // Add action listener for the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePriority();
            }
        });
    }

    private void calculatePriority() {
        // Get input values from the fields
        String name = nameField.getText();
        double effort = Double.parseDouble(effortField.getText());
        double value = Double.parseDouble(valueField.getText());

        // Calculate the priority using the 2x2 Matrix method (you need to define the logic)
        double priority = calculate2x2MatrixPriority(effort, value);

        // Display the result in the text area
        resultTextArea.setText("Task Name: " + name + "\n");
        resultTextArea.append("Effort: " + effort + "\n");
        resultTextArea.append("Value: " + value + "\n");
        resultTextArea.append("Priority: " + priority + "\n");
    }

    // Implement the logic to calculate priority using the 2x2 Matrix method
    private double calculate2x2MatrixPriority(double effort, double value) {
        // Define your prioritization logic here
        // For example, you can return the result of some calculation based on effort and value
        return effort * value;
    }
}