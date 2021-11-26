import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class KochSnowflake {
    
    private Point origin;
    private double radius;
    private Color color;
    private Point p1, p2, p3;
    private SnowflakeEdge e1, e2, e3;
    private static final double ROOT3 = Math.sqrt(3);

    public KochSnowflake(Point origin, double radius, Color color) {
        this.origin = origin;
        this.radius = radius;
        this.color = color;

        // sideLength = radius * ROOT3;

        this.p1 = new Point((int) Math.round(origin.getX() - radius / 2 * ROOT3), (int) Math.round(origin.getY() + radius / 2));
        this.p2 = new Point((int) Math.round(origin.getX() + radius / 2 * ROOT3), (int) Math.round(origin.getY() + radius / 2));
        this.p3 = new Point((int) Math.round(origin.getX()), (int) Math.round(origin.getY() - radius));

        this.e1 = new SnowflakeEdge(p1, p2, this.color);
        this.e2 = new SnowflakeEdge(p2, p3, this.color);
        this.e3 = new SnowflakeEdge(p3, p1, this.color);
    }

    public void draw(Graphics g) {
        e1.draw(g);
        e2.draw(g);
        e3.draw(g);
    }

}
