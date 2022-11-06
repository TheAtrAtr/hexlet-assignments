package exercise;

import java.util.Map;

// BEGIN
class App {

    public static void swapKeyValue(KeyValueStorage x) {
        Map<String, String> a = x.toMap();
        for (var z : a.keySet()) {
            x.unset(z);
        }
        for (var y : a.keySet()) {
            x.set(a.get(y), y);
        }
    }
}
// END
