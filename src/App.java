import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App {

    private JFrame frame;
    private JPanel panel;

    private Timer timer;

    private double rotationSpeed = 0.05;
    private JLabel label;
    private JSlider slider;
    private JPanel controlPanel;
    private DecimalFormat speedFormatter = new DecimalFormat("0.0");

    private KochSnowflake snowflake;
    private KochSnowflake innerSnowflake;

    private App(int canvasSize) {
        frame = new JFrame();
        frame.setSize(canvasSize, canvasSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        snowflake = new KochSnowflake(new Point(canvasSize/2, canvasSize/2), 300, Color.BLUE);
        innerSnowflake = new KochSnowflake(new Point(canvasSize/2, canvasSize/2), 100, Color.RED);

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                snowflake.draw(g);
                innerSnowflake.draw(g);
            }
        };

        controlPanel = new JPanel();

        label = new JLabel("Rotation Speed: " + speedFormatter.format(rotationSpeed * 100));
        controlPanel.add(label);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rotationSpeed = slider.getValue() * 0.001;
                if (rotationSpeed < 0.01) {
                    rotationSpeed = 0;
                }
                label.setText("Rotation Speed: " + speedFormatter.format(rotationSpeed * 100));
            }
        });
        controlPanel.add(slider);

        panel.add(controlPanel);

        timer = new Timer(25, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snowflake.rotate(rotationSpeed);
                innerSnowflake.rotate(-rotationSpeed);
                panel.repaint();
            }
        });
        timer.start();

        panel.setBackground(Color.WHITE);
        frame.add(panel);
    }

    public static void main(String[] args) {
        new App(800);
    }
}
