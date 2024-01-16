package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RiceMethodWindow extends JFrame {
    private JTextField taskNameField;
    private JTextField reachField;
    private JTextField impactField;
    private JTextField confidenceField;
    private JTextField effortField;
    private JButton calculateButton;
    private JButton showResultsButton;
    private List<RicePriorityResult> ricePriorityResults = new ArrayList<>();

    public RiceMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("RICE Method");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Task Name:");
        JLabel reachLabel = new JLabel("Reach:");
        JLabel impactLabel = new JLabel("Impact:");
        JLabel confidenceLabel = new JLabel("Confidence:");
        JLabel effortLabel = new JLabel("Effort:");

        taskNameField = new JTextField();
        reachField = new JTextField();
        impactField = new JTextField();
        confidenceField = new JTextField();
        effortField = new JTextField();

        calculateButton = new JButton("Calculate RICE Score");
        showResultsButton = new JButton("Show Results");

        mainPanel.add(nameLabel);
        mainPanel.add(taskNameField);
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
        mainPanel.add(new JLabel(""));
        mainPanel.add(showResultsButton);

        add(mainPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отримайте дані з полів вводу та розрахуйте RICE Score
                String taskName = taskNameField.getText();
                double reach = Double.parseDouble(reachField.getText());
                double impact = Double.parseDouble(impactField.getText());
                double confidence = Double.parseDouble(confidenceField.getText());
                double effort = Double.parseDouble(effortField.getText());

                // Розрахунок RICE Score
                double riceScore = (reach * impact * confidence) / effort;

                // Створення та додавання результату до списку
                RicePriorityResult result = new RicePriorityResult(taskName, riceScore);
                ricePriorityResults.add(result);

                // Очистити поля вводу
                taskNameField.setText("");
                reachField.setText("");
                impactField.setText("");
                confidenceField.setText("");
                effortField.setText("");
            }
        });

        showResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Сортувати результати за пріоритетом (RICE Score)
                Collections.sort(ricePriorityResults, new Comparator<RicePriorityResult>() {
                    @Override
                    public int compare(RicePriorityResult result1, RicePriorityResult result2) {
                        // Сортувати за спаданням RICE Score
                        return Double.compare(result2.getRiceScore(), result1.getRiceScore());
                    }
                });

                // Показати результати пріоритету RICE у діалоговому вікні
                StringBuilder resultsText = new StringBuilder("RICE Priority Results (Sorted by RICE Score):\n");

                // Перебираємо та додаємо відсортовані результати до тексту
                for (RicePriorityResult result : ricePriorityResults) {
                    resultsText.append("Task: ").append(result.getTaskName()).append(", RICE Score: ").append(result.getRiceScore()).append("\n");
                }

                // Відобразити результати у діалоговому вікні
                JOptionPane.showMessageDialog(RiceMethodWindow.this, resultsText.toString(), "RICE Priority Results", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Клас для представлення результатів пріоритету RICE
    private class RicePriorityResult {
        private String taskName;
        private double riceScore;

        public RicePriorityResult(String taskName, double riceScore) {
            this.taskName = taskName;
            this.riceScore = riceScore;
        }

        public String getTaskName() {
            return taskName;
        }

        public double getRiceScore() {
            return riceScore;
        }
    }
}
