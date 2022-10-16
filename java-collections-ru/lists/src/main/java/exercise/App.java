package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String arrayString, String word) {

        List<Character> characterArrayList = new ArrayList<>();
        List<Character> wordList = new ArrayList<>();
        for (char c : arrayString.toCharArray()) {
            characterArrayList.add(c);
        }
        for (char c : word.toLowerCase().toCharArray()) {
            wordList.add(c);
        }
        int k = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (characterArrayList.contains(wordList.get(i))) {
                k++;
                characterArrayList.remove(wordList.get(i));
            }
        }
        return k == wordList.size();
    }
}
//END

