package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {

    public static void main(String[] args) {
        Tag p = new PairedTag(
                "p",
                Map.of("id", "abc"),
                "Text paragraph",
                new ArrayList<Tag>()
        );

        System.out.println(p.toString()); // "<p id="abc">Text paragraph</p>"

        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );

        System.out.println(div.toString()); // "<div class="y-5"><br id="s"><hr class="a-5"></div>"
    }

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> child) {
        super(name, attributes, body, child);
    }


    @Override
    public String toString() {
        String deti = "";
        for (var x : child) {
            deti += x.toString();
        }
        String spase = " ";
        if (this.attributes.size() == 0)
            spase = "";
        String s = "";
        for (var x : attributes.keySet()) {
            s += x + "=" + "\"" + attributes.get(x) + "\"" + " ";
        }
        s = s.trim();
        return "<" + this.name + spase + s + ">" + body + deti + "</" + name + ">";
    }
}
// END
