import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class App {

    private JFrame frame;
    private JPanel panel;

    private Timer timer;

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

        timer = new Timer(25, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snowflake.rotate(0.05);
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
