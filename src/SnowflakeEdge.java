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
        drawEdge(g);
    }

    public void drawEdge(Graphics g) {
        g.setColor(color);
        g.drawLine((int) Math.round(start.getX()), (int) Math.round(start.getY()), (int) Math.round(end.getX()), (int) Math.round(end.getY()));
    }

}
