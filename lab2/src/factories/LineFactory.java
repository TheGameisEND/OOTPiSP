package factories;

import shapes.GraphicalLine;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class LineFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 2;
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        return new GraphicalLine(points.get(0), points.get(1));
    }

    @Override
    public String getName() {
        return "Line";
    }
}