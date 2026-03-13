package factories;

import shapes.GraphicalSquare;
import shapes.Point;
import shapes.GraphicalShape;
import java.util.List;

public class SquareFactory implements ShapeFactory {
    @Override
    public int getRequiredPointCount() {
        return 2; // top-left and bottom-right (side = max of width/height)
    }

    @Override
    public GraphicalShape create(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        int side = Math.max(Math.abs(p2.getX() - p1.getX()),
                Math.abs(p2.getY() - p1.getY()));
        int x = Math.min(p1.getX(), p2.getX());
        int y = Math.min(p1.getY(), p2.getY());
        return new GraphicalSquare(new Point(x, y), side);
    }

    @Override
    public String getName() {
        return "Square";
    }
}