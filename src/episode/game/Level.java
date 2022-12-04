package episode.game;

import character.game.Ghost;
import character.game.Player;

public class Level extends Chapter{
    private int levelNum=7;
    private double hardDegree=0.1;
    public Level(int chapter, int levelNum, double hardDegree, Player player){
        super(chapter,levelNum);
        this.hardDegree=hardDegree;
        Ghost ghost=new Ghost("¹í»êÀà±ð"+levelNum+"|"+chapter,chapter,levelNum);

    }
}
