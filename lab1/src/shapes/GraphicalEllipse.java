// Файл: shapes/GraphicalEllipse.java
package shapes;

import java.awt.Graphics;

public class GraphicalEllipse extends GraphicalShape {
    private Point center;
    private int radiusX, radiusY;

    public GraphicalEllipse(int x, int y, int radiusX, int radiusY) {
        this.center = new Point(x, y);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getDrawingColor());
        g.drawOval(center.getX() - radiusX, center.getY() - radiusY,
                2 * radiusX, 2 * radiusY);
    }
}