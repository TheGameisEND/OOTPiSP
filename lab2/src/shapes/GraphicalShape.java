package shapes;

/**
 * Base interface for all graphical shapes.
 * Implements the Visitor pattern: each shape accepts a visitor.
 */
public interface GraphicalShape {
    void accept(ShapeVisitor visitor);
}