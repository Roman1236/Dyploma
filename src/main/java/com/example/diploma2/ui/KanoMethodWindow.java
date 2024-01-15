package com.example.diploma2.ui;


import javax.swing.*;
import java.awt.*;

public class KanoMethodWindow extends JFrame {

    public KanoMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Kano Method");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Додайте компоненти для відображення та взаємодії з методом Kano

        add(mainPanel);
    }
}
