package ui;

import factories.ShapeFactory;
import factories.FactoryRegistry;
import shapes.GraphicalShape;
import shapes.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The drawing canvas.
 * It listens to mouse clicks, collects points according to the selected factory,
 * and creates shapes when enough points are collected.
 */
public class DrawingPanel extends JPanel {
    private ShapeList shapeList;
    private ShapeFactory currentFactory;
    private List<Point> currentPoints = new ArrayList<>();
    private JLabel statusLabel;

    public DrawingPanel(ShapeList shapeList, JLabel statusLabel) {
        this.shapeList = shapeList;
        this.statusLabel = statusLabel;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentFactory == null) {
                    statusLabel.setText("Select a shape type first.");
                    return;
                }
                currentPoints.add(new Point(e.getX(), e.getY()));
                int needed = currentFactory.getRequiredPointCount();
                if (currentPoints.size() == needed) {
                    try {
                        GraphicalShape shape = currentFactory.create(currentPoints);
                        shapeList.addShape(shape);
                        repaint();
                    } catch (Exception ex) {
                        statusLabel.setText("Error: " + ex.getMessage());
                    }
                    currentPoints.clear();
                    statusLabel.setText(currentFactory.getName() + " created. Click to start next.");
                } else {
                    statusLabel.setText(String.format("Point %d/%d collected. Click again.",
                            currentPoints.size(), needed));
                }
            }
        });
    }

    /**
     * Sets the current shape factory (called when user selects a shape from combo box).
     */
    public void setCurrentFactory(ShapeFactory factory) {
        this.currentFactory = factory;
        currentPoints.clear();
        if (factory != null) {
            statusLabel.setText(String.format("Selected: %s. Click %d point(s).",
                    factory.getName(), factory.getRequiredPointCount()));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawingVisitor visitor = new DrawingVisitor(g);
        for (GraphicalShape shape : shapeList.getAllShapes()) {
            shape.accept(visitor);
        }
        // Draw collected points (for visual feedback)
        g.setColor(Color.RED);
        for (Point p : currentPoints) {
            g.fillOval(p.getX() - 3, p.getY() - 3, 6, 6);
        }
    }
}