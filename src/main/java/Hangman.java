public class Hangman {

  private boolean mHead = false;
  private boolean mTorso = false;
  private boolean mLeftArm = false;
  private boolean mRightArm = false;
  private boolean mLeftLeg = false;
  private boolean mRightLeg = false;
  private Puzzle mPuzzle;

  public Hangman(Puzzle puzzle) {
    mPuzzle = puzzle;
  }

}
