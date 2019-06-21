package Views;

import Ships.Field;

public interface IView {

    void initMessage();

    void initUsername(int j);

    void finalScore(int shotsFired);

    void printField(Field f);

    void exitMessage();

    void playAgain(String affirmative, String negative);

    void invalidOption();

    void enterShot();

    String invalidShot();

    String invalidCharacters();

    String invalidShotRange(int gridLength);

    String userAffirmative();

    String userNegative();

    void printErrorMessage(IllegalArgumentException e);
}

