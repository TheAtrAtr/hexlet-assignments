package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

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

    public static <T> List findWhere(List<T> spisok, T slovar) {
        List<T> books = new ArrayList<>();
        String y = slovar.toString().replace("{", "").replace("}", "");
        for (int i = 0; i < spisok.size(); i++) {
            String x = spisok.get(i).toString().replace("{", "").replace("}", "");
            if (x.contains(y)){
                books.add(spisok.get(i));
            }
        }
        return books;
    }
}
//END
