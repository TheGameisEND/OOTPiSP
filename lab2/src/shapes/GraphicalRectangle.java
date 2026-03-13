package shapes;

public class GraphicalRectangle implements GraphicalShape {
    private Point topLeft;
    private int width, height;

    public GraphicalRectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Point getTopLeft() { return topLeft; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}