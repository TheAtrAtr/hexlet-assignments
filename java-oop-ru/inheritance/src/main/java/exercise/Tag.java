package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    String name;
    Map<String, String> attributes;

    String body;

    List<Tag> child;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public Tag(String name, Map<String, String> attributes, String body, List<Tag> child) {
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.child = child;
    }
}
// END
