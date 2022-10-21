package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {

    public static String getForwardedVariables(String s) {
        String[] sss = s.split("environment=\"");
        String q = Arrays.stream(sss)
                .map(x -> {
                    if (x.indexOf("\"") > 0) {
                        return x.substring(0, x.indexOf("\""));
                    }
                    return x.substring(0, 0);
                })
                .filter(x -> x.length() > 0)
                .flatMap(x -> Arrays.stream(new String[]{x}).map(y -> y.split(",")).flatMap(z -> Arrays.stream(z).filter(u -> u.startsWith("X_FORWARDED_")))
                        .map(y -> y.replace("X_FORWARDED_", "")))
                .peek(System.out::println)
                .collect(Collectors.joining(","));

        return q;
    }
}
//END
