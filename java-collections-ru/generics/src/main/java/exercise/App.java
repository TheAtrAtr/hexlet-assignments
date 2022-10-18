package exercise;

import java.util.*;

// BEGIN
class App {
    public static void main(String[] args) {
        List<Map> books = List.of(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611"),
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111"),
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611"),
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222"),
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333"),
                Map.of("title", "Happy Foo", "author", "FooBar", "year", "4444"));

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map> result = App.findWhere(books, where);

        System.out.println(result);
    }

    public static List findWhere(List<? extends Map> spisok, Map<String, String> slovar) {
        List<Map> books = new ArrayList<>();
        Set keys = slovar.keySet();
        for (int i = 0; i < spisok.size(); i++) {
            int z = 0;
            for (var x : keys) {
                if (spisok.get(i).get(x).equals(slovar.get(x))) {
                    z++;
                }
            }
            if (z == keys.size()) {
                books.add(spisok.get(i));
            }

        }
        return books;
    }
}
//END
