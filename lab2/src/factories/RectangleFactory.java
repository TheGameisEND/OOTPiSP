package factories;

import shapes.GraphicalRectangle;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class RectangleFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 2; // top-left and bottom-right
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        int x = Math.min(p1.getX(), p2.getX());
        int y = Math.min(p1.getY(), p2.getY());
        int w = Math.abs(p1.getX() - p2.getX());
        int h = Math.abs(p1.getY() - p2.getY());
        return new GraphicalRectangle(new Point(x, y), w, h);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}