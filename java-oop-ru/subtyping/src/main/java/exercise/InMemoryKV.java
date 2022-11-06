package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> map = new HashMap<>();

    public InMemoryKV(Map<String, String> a) {
        map.putAll(a);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (map.keySet().contains(key)) {
            return map.get(key);
        } else return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map2 = new HashMap<>();
        map2.putAll(map);
        return map2;
    }
}
// END
