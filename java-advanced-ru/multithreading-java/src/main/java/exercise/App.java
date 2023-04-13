package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] massiv) {
        MaxThread max = new MaxThread();
        max.setArray(massiv);
        MinThread min = new MinThread();
        min.setArray(massiv);
        max.start();

        min.start();

        try {
            max.join();

            min.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Map.of("min", min.getMin(), "max", max.getMax());
    }
    // END
}
