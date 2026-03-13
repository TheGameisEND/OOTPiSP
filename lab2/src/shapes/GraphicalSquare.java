package shapes;

public class GraphicalSquare extends GraphicalRectangle {
    public GraphicalSquare(Point topLeft, int side) {
        super(topLeft, side, side);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}