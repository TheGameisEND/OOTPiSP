package shapes;

public class GraphicalTriangle implements GraphicalShape {
    private Point v1, v2, v3;

    public GraphicalTriangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Point getV1() { return v1; }
    public Point getV2() { return v2; }
    public Point getV3() { return v3; }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}