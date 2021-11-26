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
            g.drawLine((int) Math.round(start.getX()), (int) Math.round(start.getY()), (int) Math.round(end.getX()), (int) Math.round(end.getY()));
        }
        else {
            g.drawLine((int) Math.round(start.getX()), (int) Math.round(start.getY()), (int) Math.round(end.getX()), (int) Math.round(end.getY()));
            // draw line from start to one third point
            // draw two edges
            // draw line from two thirds point to end
        }
    }

}
