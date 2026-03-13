package ui;

import shapes.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Visitor that draws shapes using a Graphics object.
 * All shapes are drawn in black on a white background.
 */
public class DrawingVisitor implements ShapeVisitor {
    private Graphics g;

    public DrawingVisitor(Graphics g) {
        this.g = g;
        g.setColor(Color.BLACK);
    }

    @Override
    public void visit(GraphicalLine line) {
        Point s = line.getStart();
        Point e = line.getEnd();
        g.drawLine(s.getX(), s.getY(), e.getX(), e.getY());
    }

    @Override
    public void visit(GraphicalRectangle rect) {
        Point tl = rect.getTopLeft();
        g.drawRect(tl.getX(), tl.getY(), rect.getWidth(), rect.getHeight());
    }

    @Override
    public void visit(GraphicalEllipse ellipse) {
        Point c = ellipse.getCenter();
        int rx = ellipse.getRadiusX();
        int ry = ellipse.getRadiusY();
        g.drawOval(c.getX() - rx, c.getY() - ry, 2 * rx, 2 * ry);
    }

    @Override
    public void visit(GraphicalCircle circle) {
        // Treat as ellipse – radii are equal
        visit((GraphicalEllipse) circle);
    }

    @Override
    public void visit(GraphicalTriangle triangle) {
        java.awt.Polygon p = new java.awt.Polygon();
        p.addPoint(triangle.getV1().getX(), triangle.getV1().getY());
        p.addPoint(triangle.getV2().getX(), triangle.getV2().getY());
        p.addPoint(triangle.getV3().getX(), triangle.getV3().getY());
        g.drawPolygon(p);
    }

    @Override
    public void visit(GraphicalSquare square) {
        // Treat as rectangle
        visit((GraphicalRectangle) square);
    }
}