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
  private ArrayList<Character> mWrongLetters;

  public Puzzle() {
    Puzzle.buildDictionary();
    String randomWord = wordDictionary.get(randomGenerator.nextInt(wordDictionary.size()));
    mWord = randomWord.toCharArray();
    mWrongGuesses = 0;
    mWrongLetters = new ArrayList<Character>();
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
      mWrongLetters.add(letter);
    }

    return this;
  }

  public int getWrongGuesses() {
    return mWrongGuesses;
  }

  public ArrayList<Character> getWrongLetters() {
    return mWrongLetters;
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
