package com.example.diploma2.ui;

import javax.swing.*;
import java.awt.*;

public class TwoByTwoMatrixMethodWindow extends JFrame {

    public TwoByTwoMatrixMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("2x2 Matrix Method");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Додайте компоненти для відображення та взаємодії з методом 2x2 Matrix

        add(mainPanel);
    }
}
