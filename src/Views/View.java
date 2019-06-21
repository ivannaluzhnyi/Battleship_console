package Views;

import Ships.Field;

public class View  implements IView{

    @Override
    public void initMessage() {
        System.out.println("=========  Jeu commence! ========");
    }
    @Override
    public void initUsername(int j){System.out.println("Entrez le nom du joueur "+ j);}

    @Override
    public void finalScore(int shotsFired) {
        System.out.println("Score final: " + shotsFired + " shots");
    }

    @Override
    public void printField(Field f) {
        System.out.println(f);
    }

    @Override
    public void exitMessage() {
        System.out.println("Quitter le programme");
    }

    @Override
    public void playAgain(String y, String n) {
        System.out.print("Rejouer? '" + y + "' or '" + n + "': ");
    }
    @Override
    public void invalidOption() {
        System.out.println("Entrée invalide. Encore une fois.");
    }

    @Override
    public void enterShot() {
        System.out.println("Entrez le numéro de ligne et de colonne (5,5) (séparer par virgule) : ");
    }

    @Override
    public String invalidShot() {
        return "Coordonnées non valides. Encore une fois";
    }

    @Override
    public String invalidCharacters() {
        return "Coordonnées non valides. Encore une fois";
    }

    @Override
    public String invalidShotRange(int gridLength) {
        return "Plage de coordonnées 0-9" + gridLength + " Encore une fois";
    }

    @Override
    public String userAffirmative() {
        return "y";
    }

    @Override
    public String userNegative() {
        return "n";
    }

    @Override
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
