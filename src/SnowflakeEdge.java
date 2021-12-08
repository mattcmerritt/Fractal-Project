import java.awt.Graphics;
import java.awt.Color;

public class SnowflakeEdge {
    
    private Point start, end;
    private Color color;
    private static final double ROOT3 = Math.sqrt(3);

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

        double startX = start.getX();
        double startY = start.getY();

        double endX = end.getX();
        double endY = end.getY();
        
        double length = Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY));

        if (length < 5) {
            g.drawLine((int) Math.round(startX), (int) Math.round(startY), (int) Math.round(endX), (int) Math.round(endY));
        }
        else {
            // find midpoint
            double midX = (startX + endX) / 2.0;
            double midY = (startY + endY) / 2.0;

            // find one third and two third points with weighted average
            double oneThirdX = startX * (2.0 / 3.0) + endX  * (1.0 / 3.0);
            double oneThirdY = startY * (2.0 / 3.0) + endY  * (1.0 / 3.0);
            Point oneThird = new Point(oneThirdX, oneThirdY);

            double twoThirdX = startX * (1.0 / 3.0) + endX  * (2.0 / 3.0);
            double twoThirdY = startY * (1.0 / 3.0) + endY  * (2.0 / 3.0);
            Point twoThird = new Point(twoThirdX, twoThirdY);

            // find the peak of the snowflake edge
            double peakX = midX - (midY - oneThirdY) * ROOT3;
            double peakY = midY + (midX - oneThirdX) * ROOT3;
            Point peak = new Point(peakX, peakY);

            // draw line from start to one third point
            // g.drawLine(startX, startY, oneThirdX, oneThirdY);
            draw(g, start, oneThird, color);

            // draw two edges
            // g.drawLine(oneThirdX, oneThirdY, peakX, peakY);
            // g.drawLine(peakX, peakY, twoThirdX, twoThirdY);
            draw(g, oneThird, peak, color);
            draw(g, peak, twoThird, color);

            // draw line from two thirds point to end
            // g.drawLine(twoThirdX, twoThirdY, endX, endY);
            draw(g, twoThird, end, color);
        }
    }

}
