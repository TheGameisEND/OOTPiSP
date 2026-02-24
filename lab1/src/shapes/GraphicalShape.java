// Файл: shapes/GraphicalShape.java
package shapes;

import java.awt.Graphics;
import java.awt.Color;

public abstract class GraphicalShape {
    public abstract void draw(Graphics g);

    protected Color getDrawingColor() {
        return Color.BLACK; // Все фигуры черные
    }
}