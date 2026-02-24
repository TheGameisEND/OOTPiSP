// Файл: Main.java
import shapes.*;
import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    private ShapeList shapeList;

    public Main() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        // Статическая инициализация - 6 разных фигур
        shapeList = new ShapeList();
        shapeList.addShape(new GraphicalLine(50, 50, 200, 100));
        shapeList.addShape(new GraphicalRectangle(250, 50, 120, 80));
        shapeList.addShape(new GraphicalEllipse(150, 200, 70, 40));
        shapeList.addShape(new GraphicalCircle(400, 200, 50));
        shapeList.addShape(new GraphicalTriangle(100, 350, 200, 400, 150, 450));
        shapeList.addShape(new GraphicalSquare(500, 350, 70));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GraphicalShape shape : shapeList.getAllShapes()) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Графические фигуры");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}