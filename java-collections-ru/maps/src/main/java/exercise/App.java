package exercise;

import java.util.*;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence = "";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);
    }

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> slovar = new LinkedHashMap<>();
        if (sentence.equals("")) {
            return slovar;
        }
        String[] strings = sentence.split(" ");
        Set<String> strings1 = new LinkedHashSet<>();
        strings1.add(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            strings1.add(strings[i]);
        }

        for (var x : strings1) {
            int i = 0;
            for (var y : strings) {
                if (x.equals(y)) {
                    i++;
                }
            }
            slovar.put(x, i);
        }
        return slovar;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.size() == 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder("{").append("\n");
        for (var test : wordsCount.entrySet()) {

            stringBuilder.append("  ").append(test.getKey()).append(": ").append(test.getValue()).append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
//END
