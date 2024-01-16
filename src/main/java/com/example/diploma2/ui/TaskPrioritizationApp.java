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


public class TaskPrioritizationApp extends JFrame {
    private List<Task> tasks = new ArrayList<>(); // Store tasks in memory
    private JPanel drawingPanel;

    public TaskPrioritizationApp() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Task Prioritization App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a form to input task parameters (name, value, cost)
        JTextField nameField = new JTextField(20);
        JTextField valueField = new JTextField(10);
        JTextField costField = new JTextField(10);
        JButton addButton = new JButton("Add Task");

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

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTasks(g);
            }
        };

        // Create a JScrollPane for the drawing panel
        JScrollPane drawingScrollPane = new JScrollPane(drawingPanel);

        // Create the main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(formPanel, BorderLayout.NORTH);
        contentPanel.add(drawingScrollPane, BorderLayout.CENTER);

        // Add the content panel to the frame
        getContentPane().add(contentPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double value = Double.parseDouble(valueField.getText());
                double cost = Double.parseDouble(costField.getText());

                Task newTask = new Task(name, cost, value);
                double priority = calculatePriority(newTask);
                newTask.setPriority(priority);
                tasks.add(newTask);

                // Sort tasks by priority
                Collections.sort(tasks, new Comparator<Task>() {
                    @Override
                    public int compare(Task task1, Task task2) {
                        return Double.compare(task2.getPriority(), task1.getPriority());
                    }
                });

                // Clear the input fields
                nameField.setText("");
                valueField.setText("");
                costField.setText("");

                // Repaint the drawing panel to update the graph
                drawingPanel.repaint();
            }
        });
    }

    // Calculate priority based on your criteria (e.g., value divided by cost)
    private double calculatePriority(Task task) {
        return task.getValue() / task.getCost();
    }

    private void drawTasks(Graphics g) {
        // Clear the panel
        g.clearRect(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());

        // Draw axes
        g.drawLine(50, 30, 50, drawingPanel.getHeight() - 30); // Vertical axis (cost)
        g.drawLine(50, drawingPanel.getHeight() - 30, drawingPanel.getWidth() - 30, drawingPanel.getHeight() - 30); // Horizontal axis (value)

        // Draw labels for axes
        g.drawString("cost", 10, drawingPanel.getHeight() - 30);
        g.drawString("value", drawingPanel.getWidth() - 30, drawingPanel.getHeight() - 10);

        // Draw scale on vertical axis (cost)
        for (int i = 0; i <= 20; i++) {
            int y = drawingPanel.getHeight() - 30 - (i * 20); // Calculate Y-coordinate for the scale
            g.drawLine(45, y, 50, y); // Draw a tick mark
            g.drawString(String.valueOf(i), 30, y + 5); // Draw the scale label
        }

        // Draw scale on horizontal axis (value)
        for (int i = 0; i <= 20; i++) {
            int x = 50 + (i * 20); // Calculate X-coordinate for the scale
            g.drawLine(x, drawingPanel.getHeight() - 25, x, drawingPanel.getHeight() - 30); // Draw a tick mark
            g.drawString(String.valueOf(i), x - 5, drawingPanel.getHeight() - 10); // Draw the scale label
        }

        // Draw tasks as points on the panel
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int x = 50 + (int) (task.getValue() * 20); // X-coordinate based on "value"
            int y = drawingPanel.getHeight() - 30 - (int) (task.getCost() * 20); // Y-coordinate based on "cost"

            // Draw a line from the origin to the task
            g.setColor(Color.GRAY);
            g.drawLine(50, drawingPanel.getHeight() - 30, x, y);

            // Draw a larger point to mark the task's position
            g.setColor(Color.BLUE);
            g.fillOval(x - 5, y - 5, 10, 10);

            // Draw task name as label
            g.setColor(Color.BLACK);
            g.drawString(task.getName(), x, y - 10);

            // Draw priority value as label
            g.drawString(String.format("%.2f", task.getPriority()), x, y + 20);
        }
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskPrioritizationApp app = new TaskPrioritizationApp();
            app.setVisible(true);
        });
    }
}
