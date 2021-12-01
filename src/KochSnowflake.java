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

        this.p1 = new Point(origin.getX() - radius / 2 * ROOT3, origin.getY() + radius / 2);
        this.p2 = new Point(origin.getX() + radius / 2 * ROOT3, origin.getY() + radius / 2);
        this.p3 = new Point(origin.getX(), origin.getY() - radius);

        this.e1 = new SnowflakeEdge(p1, p2, this.color);
        this.e2 = new SnowflakeEdge(p2, p3, this.color);
        this.e3 = new SnowflakeEdge(p3, p1, this.color);
    }

    public void draw(Graphics g) {
        e1.draw(g);
        e2.draw(g);
        e3.draw(g);
    }

    public void rotate(double angle) {
        rotatePoint(p1, angle);
        rotatePoint(p2, angle);
        rotatePoint(p3, angle);
    }

    private void rotatePoint(Point p, double angle) {
        double newX = (p.getX() - origin.getX() * Math.cos(angle) - (p.getY() - origin.getY()) * Math.sin(angle) + origin.getX());
        double newY = (p.getY() - origin.getY() * Math.cos(angle) + (p.getX() - origin.getX()) * Math.sin(angle) + origin.getY());

        p.setLocation(newX, newY);
    }
}
