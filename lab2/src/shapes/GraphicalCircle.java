package shapes;

public class GraphicalCircle extends GraphicalEllipse {
    public GraphicalCircle(Point center, int radius) {
        super(center, radius, radius);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}