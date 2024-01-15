package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;

public class ValueOverCostMethodWindow extends JFrame {

    public ValueOverCostMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Value Over Cost Method");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Додайте компоненти для відображення та взаємодії з методом Value Over Cost

        add(mainPanel);
    }
}
