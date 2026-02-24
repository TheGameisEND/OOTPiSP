// Файл: shapes/GraphicalTriangle.java
package shapes;

import java.awt.Graphics;
import java.awt.Polygon;

public class GraphicalTriangle extends GraphicalShape {
    private Point v1, v2, v3;

    public GraphicalTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new Point(x1, y1);
        this.v2 = new Point(x2, y2);
        this.v3 = new Point(x3, y3);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getDrawingColor());
        Polygon polygon = new Polygon();
        polygon.addPoint(v1.getX(), v1.getY());
        polygon.addPoint(v2.getX(), v2.getY());
        polygon.addPoint(v3.getX(), v3.getY());
        g.drawPolygon(polygon);
    }
}