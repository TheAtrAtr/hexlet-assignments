package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String spase = " ";
        if (this.attributes.size() == 0)
            spase = "";
        String s = "";
        for (var x : attributes.keySet()) {
            s += x + "=" + "\"" + attributes.get(x) + "\"" + " ";
        }
        s = s.trim();
        return "<" + this.name + spase + s + ">";
    }
}
// END
