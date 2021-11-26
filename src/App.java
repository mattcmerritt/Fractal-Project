import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.*;

public class App {

    private JFrame frame;
    private JPanel panel;

    private KochSnowflake snowflake;

    private App(int canvasSize) {
        frame = new JFrame();
        frame.setSize(canvasSize, canvasSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        snowflake = new KochSnowflake(new Point(canvasSize/2, canvasSize/2), 300, Color.BLUE);

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLACK);
                snowflake.draw(g);
            }
        };

        panel.setBackground(Color.WHITE);
        frame.add(panel);
    }

    public static void main(String[] args) {
        new App(800);
    }
}
