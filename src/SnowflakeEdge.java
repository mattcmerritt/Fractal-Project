import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class SnowflakeEdge {
    
    private Point start, end;
    private Color color;

    public SnowflakeEdge(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public void draw(Graphics g) {
        draw(g, start, end, color);
    }

    public void draw(Graphics g, Point start, Point end, Color color) {
        g.setColor(color);

        int startX = (int) Math.round(start.getX());
        int startY = (int) Math.round(start.getY());

        int endX = (int) Math.round(end.getX());
        int endY = (int) Math.round(end.getY());
        
        double length = Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY));

        if (length < 2) {
            g.drawLine(startX, startY, endX, endY);
        }
        else {
            // draw line from start to one third point using a weighted average
            int oneThirdX = (int) Math.round(startX * (2.0 / 3.0) + endX  * (1.0 / 3.0));
            int oneThirdY = (int) Math.round(startY * (2.0 / 3.0) + endY  * (1.0 / 3.0));

            g.drawLine(startX, startY, oneThirdX, oneThirdY);

            // draw two edges
            

            // draw line from two thirds point to end using a weighted average
            int twoThirdX = (int) Math.round(startX * (1.0 / 3.0) + endX  * (2.0 / 3.0));
            int twoThirdY = (int) Math.round(startY * (1.0 / 3.0) + endY  * (2.0 / 3.0));

            g.drawLine(twoThirdX, twoThirdY, endX, endY);
        }
    }

}
