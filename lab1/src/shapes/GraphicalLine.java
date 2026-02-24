// Файл: shapes/GraphicalLine.java
package shapes;

import java.awt.Graphics;

public class GraphicalLine extends GraphicalShape {
    private Point start, end;

    public GraphicalLine(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getDrawingColor());
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}