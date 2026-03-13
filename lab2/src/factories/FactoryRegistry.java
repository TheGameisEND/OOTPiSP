package factories;

import java.util.*;

/**
 * Registry of all available shape factories.
 * New factories are added here, and the rest of the code uses this registry.
 * No switch or if-else is needed when adding a new shape – just register it.
 */
public class FactoryRegistry {
    private static final Map<String, ShapeFactory> factories = new LinkedHashMap<>();

    static {
        register(new LineFactory());
        register(new RectangleFactory());
        register(new EllipseFactory());
        register(new CircleFactory());
        register(new TriangleFactory());
        register(new SquareFactory());
    }

    private static void register(ShapeFactory factory) {
        factories.put(factory.getName(), factory);
    }

    public static Collection<ShapeFactory> getAllFactories() {
        return factories.values();
    }

    public static ShapeFactory getFactory(String name) {
        return factories.get(name);
    }
}