package ui;

import shapes.GraphicalShape;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for storing all shapes drawn in the editor.
 */
public class ShapeList {
    private List<GraphicalShape> shapes = new ArrayList<>();

    public void addShape(GraphicalShape shape) {
        shapes.add(shape);
    }

    public List<GraphicalShape> getAllShapes() {
        return shapes;
    }

    public void clear() {
        shapes.clear();
    }
}