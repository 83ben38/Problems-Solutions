package A;

import java.util.*;

class Player {
    /**
     * Tells you the list of words before the game starts.
     */
    ArrayList<String> wordsLeft;
    String lastWord;
    public Player(ArrayList<String> words) {
        wordsLeft = words;
        wordsLeft.sort(String::compareTo);
    }

    /**
     * Return a word that has not been said yet.
     */
    String my_turn() {
        String returner = wordsLeft.indexOf(lastWord) == wordsLeft.size()-1 ? wordsLeft.get(0) : wordsLeft.get(wordsLeft.indexOf(lastWord)+1);
        wordsLeft.remove(lastWord);
        return returner;
    }

    /**
     * Tells you when an opponent says a word
     */
    void opponent_turn(String word) {
        wordsLeft.remove(lastWord);
        lastWord = word;
    }
}
//do not edit below this line
public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p = s.nextInt();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(s.next());
            words2.add(words.get(words.size()-1));
        }
        Player player = new Player(words2);
        while (words.size() > 0) {
            for (int i = 0; i < p - 1; i++) {
                System.out.println(words.get(0));
                player.opponent_turn(words.remove(0));
                if (words.size() == 0){
                    break;
                }
            }
            if (words.size() > 0) {
                String string = player.my_turn();
                words.remove(string);
                System.out.println(string);
            }
        }
    }
}