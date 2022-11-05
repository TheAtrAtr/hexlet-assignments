package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildAppartmentsList(List<Home> a, int n) {
        return a.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(x -> x.toString())
                .limit(n)
                .collect(Collectors.toList());
    }
}
// END
