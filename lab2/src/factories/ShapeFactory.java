package factories;

import shapes.GraphicalShape;
import shapes.Point;
import java.util.List;

/**
 * Factory interface for creating shapes from a list of points.
 * Each concrete factory knows how many points it needs and how to build the shape.
 */
public interface ShapeFactory {
    /**
     * @return number of points required to create the shape
     */
    int getRequiredPointCount();

    /**
     * Creates a shape from the given points.
     * @param points list of points (size must equal getRequiredPointCount())
     * @return the new shape
     */
    GraphicalShape create(List<Point> points);

    /**
     * @return display name of the shape (used in UI)
     */
    String getName();
}