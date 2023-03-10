package lab5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test extends JFrame {
    private static final long serialVersionUID = 6617760910198114903L;
    private static final int NEW_SHAPE_FREQUENCY = 500; // every second new shape
    private List<Shape> shapes = new ArrayList<>(); // Keep the shapes
    private JPanel shapePanel;
    private Timer timer; //A javax.swing.Timer

    public test() {
        super("Random shapes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // set border layout to the content pane
        shapePanel = new JPanel() {
            /*
             * Override paint component in order to add custom painting to this panel. But
             * of course, start by calling super.paintComponent()
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape s : shapes) {
                    g.setColor(s.color);
                    g.fillRect(s.x, s.y, s.width, s.height);
                }
            }
        };
        // Add it to the center of the border layout in order to take all window space
        add(shapePanel, BorderLayout.CENTER);
        setSize(400, 400);
        setLocationRelativeTo(null);
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(NEW_SHAPE_FREQUENCY, e -> {
            shapes.add(new Shape()); // Add a new shape to the arraylist
            shapePanel.repaint(); // Repaint the panel, so the new shape is visible
        });
        int i = 0;
        timer.start();
    }

    private static class Shape {
        private int x, y, height, width;
        private Color color;

        private Shape() {

            height = random(100);
            width = random(100);
            color = new Color(random(255), random(255), random(255));

        }

        private static int random(int max) {
            return (int) (Math.random() * max);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test().setVisible(true));
    }
}