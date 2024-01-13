// ExistingTasksWindow.java
package com.example.diploma2.ui;

import com.example.diploma2.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExistingTasksWindow extends JFrame {
    private JList<Task> tasksList;
    private JButton viewButton;

    public ExistingTasksWindow(List<Task> tasks) {
        initializeUI(tasks);
    }

    private void initializeUI(List<Task> tasks) {
        setTitle("Список завдань");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        DefaultListModel<Task> tasksListModel = new DefaultListModel<>();
        tasks.forEach(tasksListModel::addElement);
        tasksList = new JList<>(tasksListModel);
        JScrollPane scrollPane = new JScrollPane(tasksList);

        viewButton = new JButton("Переглянути");

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(viewButton, BorderLayout.SOUTH);

        add(mainPanel);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task selectedTask = tasksList.getSelectedValue();

                if (selectedTask != null) {
                    // Відображення вибраної задачі
                    String taskDetails = "Назва: " + selectedTask.getName() + "\n"
                            + "Цінність: " + selectedTask.getValue() + "\n"
                            + "Витрати: " + selectedTask.getCost();

                    JOptionPane.showMessageDialog(ExistingTasksWindow.this,
                            "Вибрана задача: " + selectedTask.getName(),
                            "Деталі задачі",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ExistingTasksWindow.this,
                            "Спершу виберіть задачу для перегляду.",
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
