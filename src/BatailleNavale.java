
import Ships.Field;
import Views.View;
import Views.IView;

public class BatailleNavale implements IBatailleNavale {
    public void start()
    {
        View view1 = new View();
        Field f1 = new Field();

        Game game = new Game(view1, f1);
        game.start();
    }
}
