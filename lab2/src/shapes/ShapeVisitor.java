package shapes;

/**
 * Visitor interface for shapes.
 * Contains a visit method for each concrete shape type.
 */
public interface ShapeVisitor {
    void visit(GraphicalLine line);
    void visit(GraphicalRectangle rectangle);
    void visit(GraphicalEllipse ellipse);
    void visit(GraphicalCircle circle);
    void visit(GraphicalTriangle triangle);
    void visit(GraphicalSquare square);
}