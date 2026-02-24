// Файл: shapes/ShapeList.java
package shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeList {
    private List<GraphicalShape> shapes = new ArrayList<>();

    public void addShape(GraphicalShape shape) {
        shapes.add(shape);
    }

    public List<GraphicalShape> getAllShapes() {
        return shapes;
    }
}