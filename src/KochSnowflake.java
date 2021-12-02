import java.awt.Graphics;
import java.awt.Color;

public class KochSnowflake {
    
    private Point origin;
    private double radius;
    private double rotationAngle;
    private Color color;
    private Point startP1, startP2, startP3;
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

        startP1 = Point.createCopy(p1);
        startP2 = Point.createCopy(p2);
        startP3 = Point.createCopy(p3);

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
        rotationAngle += angle;
        rotatePoint(p1, startP1, rotationAngle);
        rotatePoint(p2, startP2, rotationAngle);
        rotatePoint(p3, startP3, rotationAngle);
    }

    private void rotatePoint(Point pointToChange, Point startPoint, double rotationAngle) {
        double newX = (startPoint.getX() - origin.getX()) * Math.cos(rotationAngle) - (startPoint.getY() - origin.getY()) * Math.sin(rotationAngle) + origin.getX();
        double newY = (startPoint.getX() - origin.getX()) * Math.sin(rotationAngle) + (startPoint.getY() - origin.getY()) * Math.cos(rotationAngle) + origin.getY();

        pointToChange.setLocation(newX, newY);
    }
}
