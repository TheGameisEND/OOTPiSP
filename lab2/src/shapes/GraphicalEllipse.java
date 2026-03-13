package shapes;

public class GraphicalEllipse implements GraphicalShape {
    private Point center;
    private int radiusX, radiusY;

    public GraphicalEllipse(Point center, int radiusX, int radiusY) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Point getCenter() { return center; }
    public int getRadiusX() { return radiusX; }
    public int getRadiusY() { return radiusY; }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}