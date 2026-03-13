package factories;

import shapes.GraphicalEllipse;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class EllipseFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 2; // center and a point on the ellipse
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        Point center = points.get(0);
        Point p = points.get(1);
        int radiusX = Math.abs(p.getX() - center.getX());
        int radiusY = Math.abs(p.getY() - center.getY());
        return new GraphicalEllipse(center, radiusX, radiusY);
    }

    @Override
    public String getName() {
        return "Ellipse";
    }
}