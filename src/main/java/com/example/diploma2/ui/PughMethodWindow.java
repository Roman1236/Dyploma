package com.example.diploma2.ui;

import com.example.diploma2.model.PughTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PughMethodWindow extends JFrame {
    private List<PughTask> pughTasks = new ArrayList<>();
    private JList<String> resultList;
    private DefaultListModel<String> listModel;

    public PughMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Pugh Method");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(10, 3));

        // Labels for Task Name, Criteria, Importance Weighting, and Score
        inputPanel.add(new JLabel("Task Name:"));
        JTextField taskNameField = new JTextField();
        inputPanel.add(taskNameField);
        inputPanel.add(new JLabel(""));

        inputPanel.add(new JLabel("Criteria"));
        inputPanel.add(new JLabel("Importance Weighting"));
        inputPanel.add(new JLabel("Score"));

        // Create labels and fields for criteria, importance weighting, and score
        String[] criteria = {
                "Effectiveness", "Availability of Resources", "Support from Business",
                "Long Term Benefit", "Time to Implement", "Ease to Implement", "Cost to Implement"
        };

        JTextField[] importanceWeightingFields = new JTextField[7];
        JTextField[] scoreFields = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            JLabel criterionLabel = new JLabel(criteria[i]);
            JTextField importanceWeightingField = new JTextField();
            JTextField scoreField = new JTextField();

            inputPanel.add(criterionLabel);
            inputPanel.add(importanceWeightingField);
            inputPanel.add(scoreField);

            importanceWeightingFields[i] = importanceWeightingField;
            scoreFields[i] = scoreField;
        }

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PughTask pughTask = new PughTask();
                pughTask.setName(taskNameField.getText()); // Set Task Name

                // Set importance weighting and score for each criterion
                for (int i = 0; i < 7; i++) {
                    String criterion = criteria[i];
                    double importanceWeighting = Double.parseDouble(importanceWeightingFields[i].getText());
                    double score = Double.parseDouble(scoreFields[i].getText());

                    pughTask.getCriteriaImportance().put(criterion, importanceWeighting);
                    pughTask.getCriteriaScores().put(criterion, score);
                }

                // Calculate and set the total score
                double totalScore = pughTask.calculateTotalScore();
                pughTask.setTotalScore(totalScore);

                // Add the PughTask to the list
                pughTasks.add(pughTask);

                // Update the result list
                updateResultList();
            }
        });

        inputPanel.add(new JLabel(""));
        inputPanel.add(calculateButton);
        inputPanel.add(new JLabel(""));

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Create and configure the result list
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(resultList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void updateResultList() {
        listModel.clear();
        pughTasks.sort((p1, p2) -> Double.compare(p2.getTotalScore(), p1.getTotalScore()));
        for (int i = 0; i < pughTasks.size(); i++) {
            PughTask pughTask = pughTasks.get(i);
            listModel.addElement("" + (i + 1) + ": " + pughTask.getName() + " - Total Score = " + pughTask.getTotalScore());
        }
    }
}
