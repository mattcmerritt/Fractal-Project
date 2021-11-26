import java.awt.Point;
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

        int startX = (int) Math.round(start.getX());
        int startY = (int) Math.round(start.getY());

        int endX = (int) Math.round(end.getX());
        int endY = (int) Math.round(end.getY());
        
        double length = Math.sqrt((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY));

        if (length < 5) {
            g.drawLine(startX, startY, endX, endY);
        }
        else {
            // find midpoint
            int midX = (int) Math.round((startX + endX) / 2.0);
            int midY = (int) Math.round((startY + endY) / 2.0);

            // find one third and two third points with weighted average
            int oneThirdX = (int) Math.round(startX * (2.0 / 3.0) + endX  * (1.0 / 3.0));
            int oneThirdY = (int) Math.round(startY * (2.0 / 3.0) + endY  * (1.0 / 3.0));
            Point oneThird = new Point(oneThirdX, oneThirdY);

            int twoThirdX = (int) Math.round(startX * (1.0 / 3.0) + endX  * (2.0 / 3.0));
            int twoThirdY = (int) Math.round(startY * (1.0 / 3.0) + endY  * (2.0 / 3.0));
            Point twoThird = new Point(twoThirdX, twoThirdY);

            // find the peak of the snowflake edge
            int peakX = (int) Math.round(midX - (midY - oneThirdY) * ROOT3);
            int peakY = (int) Math.round(midY + (midX - oneThirdX) * ROOT3);
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
