package factories;

import shapes.GraphicalTriangle;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class TriangleFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 3;
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        return new GraphicalTriangle(points.get(0), points.get(1), points.get(2));
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}