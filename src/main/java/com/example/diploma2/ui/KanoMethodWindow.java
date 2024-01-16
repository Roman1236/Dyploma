package com.example.diploma2.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KanoMethodWindow extends JFrame {
    private JTextField nameField;
    private JTextField productSatisfactionField;
    private JTextField functionalityField;
    private JButton calculateButton;
    private JPanel graphPanel; // Панель для відображення графіку

    // Кольори та підписи для зон графіку
    private Color[] zoneColors = {Color.RED, Color.BLUE, Color.GREEN, Color.GRAY};
    private String[] zoneLabels = {"Indifferent", "Productive", "Attractive", "Must-Be"};

    private List<String> taskNames = new ArrayList<>(); // Список імен завдань
    private List<Double> productSatisfactions = new ArrayList<>(); // Список рівнів задоволення продуктом
    private List<Double> functionalities = new ArrayList<>(); // Список функціональностей
    private List<Point> taskCoordinates = new ArrayList<>(); // Список координат завдань

    public KanoMethodWindow() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Kano Method");
        setSize(800, 600); // Збільшив розмір вікна для зручності
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Task Name:");
        nameField = new JTextField();
        JLabel productSatisfactionLabel = new JLabel("Product Satisfaction:");
        productSatisfactionField = new JTextField();
        JLabel functionalityLabel = new JLabel("Functionality:");
        functionalityField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(productSatisfactionLabel);
        inputPanel.add(productSatisfactionField);
        inputPanel.add(functionalityLabel);
        inputPanel.add(functionalityField);

        calculateButton = new JButton("Calculate Kano Score");
        inputPanel.add(new JLabel(""));
        inputPanel.add(calculateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawKanoGraph(g);
            }
        };
        mainPanel.add(new JScrollPane(graphPanel), BorderLayout.CENTER);

        add(mainPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateKanoScore();
                repaint(); // Оновлення графіку після обчислення
            }
        });
    }

    private void calculateKanoScore() {
        String name = nameField.getText();
        double productSatisfaction = Double.parseDouble(productSatisfactionField.getText());
        double functionality = Double.parseDouble(functionalityField.getText());

        // Додаємо дані про завдання до списків
        taskNames.add(name);
        productSatisfactions.add(productSatisfaction);
        functionalities.add(functionality);

        // Визначаємо координати завдання
        int x = (int) (productSatisfaction * 20); // Множимо на 20 для масштабування
        int y = (int) (functionality * 20);

        taskCoordinates.add(new Point(x, y)); // Додаємо координати до списку
    }

    // Метод для малювання графіку Кано
    private void drawKanoGraph(Graphics g) {
        // Розміри зон графіку
        int zoneWidth = graphPanel.getWidth() / 2;
        int zoneHeight = graphPanel.getHeight() / 2;

        // Рисуємо кольорові зони та підписи
        for (int i = 0; i < zoneColors.length; i++) {
            g.setColor(zoneColors[i]);
            g.fillRect(i % 2 * zoneWidth, i / 2 * zoneHeight, zoneWidth, zoneHeight);
            g.setColor(Color.BLACK);
            g.drawRect(i % 2 * zoneWidth, i / 2 * zoneHeight, zoneWidth, zoneHeight);
            g.drawString(zoneLabels[i], i % 2 * zoneWidth + 10, i / 2 * zoneHeight + 20);
        }

        // Рисуємо прямокутники для завдань на основі їх координат
        g.setColor(Color.YELLOW); // Колір прямокутників із завданнями
        for (int i = 0; i < taskCoordinates.size(); i++) {
            Point coordinates = taskCoordinates.get(i);
            int x = coordinates.x;
            int y = coordinates.y;
            g.drawRect(x, y, 10, 10); // Розмір прямокутника - 10x10
            g.fillRect(x, y, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString(taskNames.get(i), x, y - 5); // Відображення імені завдання над прямокутником
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                KanoMethodWindow window = new KanoMethodWindow();
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
