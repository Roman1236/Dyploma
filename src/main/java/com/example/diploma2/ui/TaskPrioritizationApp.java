package com.example.diploma2.ui;

import com.example.diploma2.model.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskPrioritizationApp {
    private static List<Task> tasks = new ArrayList<>(); // Store tasks in memory

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Task Prioritization App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a form to input task parameters (name, value, cost)
            JTextField nameField = new JTextField(20);
            JTextField valueField = new JTextField(10);
            JTextField costField = new JTextField(10);
            JButton addButton = new JButton("Add Task");

            // Create a text area to display tasks and their priorities
            JTextArea tasksTextArea = new JTextArea();
            tasksTextArea.setEditable(false);

            // Add an action listener to the "Add Task" button
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the input values from the form
                    String name = nameField.getText();
                    double value = Double.parseDouble(valueField.getText());
                    double cost = Double.parseDouble(costField.getText());

                    // Create a Task object with the input values
                    Task newTask = new Task(name, cost, value);

                    // Calculate the priority and set it for the new task
                    double priority = calculatePriority(newTask);
                    newTask.setPriority(priority);

                    // Add the task to the list
                    tasks.add(newTask);

                    // Sort tasks by priority
                    Collections.sort(tasks, new Comparator<Task>() {
                        @Override
                        public int compare(Task task1, Task task2) {
                            return Double.compare(task2.getPriority(), task1.getPriority());
                        }
                    });

                    // Update the UI with the sorted task list
                    tasksTextArea.setText("");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task = tasks.get(i);
                        tasksTextArea.append((i + 1) + ". Name: " + task.getName() + ", Value: " + task.getValue() +
                                ", Cost: " + task.getCost() + ", Priority: " + task.getPriority() + "\n");
                    }

                    // Clear the input fields
                    nameField.setText("");
                    valueField.setText("");
                    costField.setText("");
                }
            });

            // Create a panel for the form components
            JPanel formPanel = new JPanel(new GridLayout(4, 2));
            formPanel.add(new JLabel("Name:"));
            formPanel.add(nameField);
            formPanel.add(new JLabel("Value:"));
            formPanel.add(valueField);
            formPanel.add(new JLabel("Cost:"));
            formPanel.add(costField);
            formPanel.add(new JLabel(""));
            formPanel.add(addButton);

            // Create a panel for the task list
            JPanel taskListPanel = new JPanel(new BorderLayout());
            taskListPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));
            taskListPanel.add(new JScrollPane(tasksTextArea), BorderLayout.CENTER);

            // Create the main content panel
            JPanel contentPanel = new JPanel(new BorderLayout());
            contentPanel.add(formPanel, BorderLayout.NORTH);
            contentPanel.add(taskListPanel, BorderLayout.CENTER);

            frame.getContentPane().add(contentPanel);
            frame.setVisible(true);
        });
    }

    // Calculate priority based on your criteria (e.g., value divided by cost)
    private static double calculatePriority(Task task) {
        return task.getValue() / task.getCost();
    }
}
