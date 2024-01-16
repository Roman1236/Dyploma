package com.example.diploma2.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TwoByTwoMatrixMethodWindow extends JFrame {
    private JTextField nameField;
    private JTextField effortField;
    private JTextField valueField;
    private JPanel resultPanel;
    private List<TaskRectangle> taskRectangles = new ArrayList<>();

    public TwoByTwoMatrixMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("2x2 Matrix Method");
        setSize(800, 600);
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

        JButton calculateButton = new JButton("Calculate Priority");
        inputPanel.add(new JLabel("")); // Empty label for spacing
        inputPanel.add(calculateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Create and configure the result panel for displaying tasks and priorities
        resultPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                // Draw horizontal and vertical axes with labels
                int xAxisY = getHeight() - 50; // Y-coordinate of the X-axis
                int yAxisX = 50;              // X-coordinate of the Y-axis


                g.drawLine(0, xAxisY, getWidth(), xAxisY); // Horizontal line (X-axis)
                g.drawLine(yAxisX, 0, yAxisX, getHeight()); // Vertical line (Y-axis)

                // Label the axes
                g.drawString("Importance", yAxisX + 5, xAxisY + 15);
                g.drawString("Value", yAxisX - 35, xAxisY - 5);



                int yLineY = xAxisY - 10 * 20;
                g.setColor(Color.BLACK); // Set color to black
                g.drawLine(yAxisX, yLineY, getWidth(), yLineY);

                // Draw the vertical line at x = 10 on the Value axis
                int xLineX = yAxisX + 10 * 20;
                g.drawLine(xLineX, 0, xLineX, getHeight());



                // Draw marks and labels on the axes
                for (int i = 0; i <= 20; i++) {
                    int xMark = yAxisX + i * 20; // X-coordinate of the mark
                    int yMark = xAxisY - i * 20; // Y-coordinate of the mark

                    // Draw horizontal marks on the Y-axis
                    g.drawLine(yAxisX - 5, yMark, yAxisX + 5, yMark);

                    // Draw vertical marks on the X-axis
                    g.drawLine(xMark, xAxisY - 5, xMark, xAxisY + 5);

                    // Label the marks with values
                    g.drawString(Integer.toString(i), xMark - 5, xAxisY + 20);
                    g.drawString(Integer.toString(i), yAxisX - 25, yMark + 5);
                }

                // Draw task rectangles
                for (TaskRectangle rectangle : taskRectangles) {
                    rectangle.draw(g, xAxisY, yAxisX);
                }
            }
        };
        mainPanel.add(resultPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Add action listener for the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
    }

    private void addTask() {
        // Get input values from the fields
        String name = nameField.getText();
        double effort = Double.parseDouble(effortField.getText());
        double value = Double.parseDouble(valueField.getText());

        // Calculate the priority using the 2x2 Matrix method
        double priority = calculate2x2MatrixPriority(effort, value);

        // Create a TaskRectangle to represent the task and its priority
        TaskRectangle taskRectangle = new TaskRectangle(name, priority, effort, value);

        // Add the TaskRectangle to the list and repaint the result panel
        taskRectangles.add(taskRectangle);
        resultPanel.repaint();
    }

    // Implement the logic to calculate priority using the 2x2 Matrix method
    private double calculate2x2MatrixPriority(double effort, double value) {
        if (effort == 0) {
            // Handle the case where effort is 0 to avoid division by zero
            return 0.0;
        }
        return value / effort;
    }

    // Inner class for representing a task rectangle with name and priority
    private class TaskRectangle {
        private String name;
        private double priority;
        private double effort;
        private double value;

        public TaskRectangle(String name, double priority, double effort, double value) {
            this.name = name;
            this.priority = priority;
            this.effort = effort;
            this.value = value;
        }

        public void draw(Graphics g, int xAxisY, int yAxisX) {
            int x = (int) (effort * 50) + yAxisX; // Scale effort for x-coordinate
            int y = xAxisY - (int) (value * 50);  // Scale value for y-coordinate
            int width = 50;
            int height = 50;

            g.setColor(Color.BLUE); // Change color as needed
            g.fillRect(x, y, width, height);

            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);

            g.drawString(name, x + 5, y + 15);          // Display name
            g.drawString("Priority: " + priority, x + 5, y + 30); // Display priority
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoByTwoMatrixMethodWindow window = new TwoByTwoMatrixMethodWindow();
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
