import java.util.Random;
import java.util.ArrayList;
import java.lang.Iterable;

public class Puzzle {

  private static Random randomGenerator = new Random();
  private static ArrayList<String> wordDictionary = new ArrayList<String>();
  public static ArrayList<String> buildDictionary() {
    wordDictionary.add("goose");
    wordDictionary.add("chicken");
    wordDictionary.add("parrot");
    wordDictionary.add("turkey");
    wordDictionary.add("pigeon");
    return wordDictionary;
  }

  private char[] mWord;
  private int mWrongGuesses;

  public Puzzle() {
    Puzzle.buildDictionary();
    String randomWord = wordDictionary.get(randomGenerator.nextInt(wordDictionary.size()));
    mWord = randomWord.toCharArray();
    mWrongGuesses = 0;
  }

  public Puzzle guess(char letter) {
    boolean matches = false;
    for (char unknown : mWord) {
      if (unknown == letter) {
        unknown = '-';
        matches = true;
      }
    }
    if (!matches) {
      mWrongGuesses ++;
    }
    return this;
  }

  public boolean gameOver() {
    if (mWrongGuesses > 6 || isSolved()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isSolved() {
    for (char letter : mWord) {
      if (letter == '-') {
      } else {
        return false;
      }
    }
    return true;
  }
}
