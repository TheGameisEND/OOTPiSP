package factories;

import shapes.GraphicalCircle;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class CircleFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 2; // center and a point on the circle
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        Point center = points.get(0);
        Point p = points.get(1);
        int radius = (int) Math.round(Math.hypot(p.getX() - center.getX(),
                p.getY() - center.getY()));
        return new GraphicalCircle(center, radius);
    }

    @Override
    public String getName() {
        return "Circle";
    }
}