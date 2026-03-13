import factories.FactoryRegistry;
import factories.ShapeFactory;
import ui.DrawingPanel;
import ui.ShapeList;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graphic Editor");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ShapeList shapeList = new ShapeList();
            JLabel statusLabel = new JLabel("Select a shape type from the list.");

            DrawingPanel canvas = new DrawingPanel(shapeList, statusLabel);

            // Control panel
            JPanel controlPanel = new JPanel();
            controlPanel.add(new JLabel("Shape:"));
            JComboBox<String> shapeCombo = new JComboBox<>();
            for (ShapeFactory factory : FactoryRegistry.getAllFactories()) {
                shapeCombo.addItem(factory.getName());
            }
            shapeCombo.addActionListener(e -> {
                String name = (String) shapeCombo.getSelectedItem();
                ShapeFactory factory = FactoryRegistry.getFactory(name);
                canvas.setCurrentFactory(factory);
            });
            controlPanel.add(shapeCombo);

            JButton clearButton = new JButton("Clear All");
            clearButton.addActionListener(e -> {
                shapeList.clear();
                canvas.repaint();
                statusLabel.setText("All shapes cleared.");
            });
            controlPanel.add(clearButton);

            // Layout
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(canvas, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}