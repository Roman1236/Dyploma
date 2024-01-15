package com.example.diploma2.ui;


import javax.swing.*;
import java.awt.*;

public class PughMethodWindow extends JFrame {

    public PughMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Pugh Method");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Додайте компоненти для відображення та взаємодії з методом Pugh

        add(mainPanel);
    }
}
