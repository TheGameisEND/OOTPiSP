// Файл: shapes/GraphicalRectangle.java
package shapes;

import java.awt.Graphics;

public class GraphicalRectangle extends GraphicalShape {
    private Point topLeft;
    private int width, height;

    public GraphicalRectangle(int x, int y, int width, int height) {
        this.topLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getDrawingColor());
        g.drawRect(topLeft.getX(), topLeft.getY(), width, height);
    }
}