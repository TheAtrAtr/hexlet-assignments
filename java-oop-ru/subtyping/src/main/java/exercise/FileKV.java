package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private Map<String, String> map = new HashMap<>();
    private String file;

    public FileKV(String file, Map<String, String> a) {
        map.putAll(a);
        this.file = file;
        String content = Utils.serialize(map);
        Utils.writeFile(file, content);
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(file);
        Map<String, String> unser = Utils.unserialize(content);
        unser.put(key, value);
        new FileKV(file, unser);
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(file);
        Map<String, String> unser = Utils.unserialize(content);
        unser.remove(key);
        new FileKV(file, unser);
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(file);
        Map<String, String> unser = Utils.unserialize(content);
        if (unser.keySet().contains(key)) {
            return unser.get(key);
        } else return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(file);
        Map<String, String> unser = Utils.unserialize(content);
        return unser;
    }
}
// END
