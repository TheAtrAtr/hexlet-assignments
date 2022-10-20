package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

// BEGIN
class App {

    public static String[][] enlargeArrayImage(String[][] array) {
        String[][] strings = Arrays.stream(array)
                .map(x -> Arrays.stream(x).flatMap(y -> Stream.of(y, y)).toArray(String[]::new))
                .flatMap(x -> Stream.of(x, x))
                .toArray(String[][]::new);
        return strings;
    }
}
// END
