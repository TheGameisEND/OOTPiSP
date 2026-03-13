package shapes;

public class GraphicalLine implements GraphicalShape {
    private Point start, end;

    public GraphicalLine(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}