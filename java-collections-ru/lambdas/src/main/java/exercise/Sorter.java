package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {

        return list.stream()
                .filter(x -> x.get("gender").equals("male"))
                .sorted(Comparator.comparing(name -> name.get("birthday")))
                .map(x -> x.get("name"))
                .collect(Collectors.toList());
    }
}
// END
