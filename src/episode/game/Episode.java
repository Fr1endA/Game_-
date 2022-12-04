package episode.game;

import character.game.EliteGhost;
import character.game.Ghost;
import character.game.Normal_Ghost;
import character.game.Player;

public class Episode {
    private int levelNum=1;
    private double hardDegree=0.1;
    private int chapterNum=1;
    public Ghost ghost;
    public static int countNormal=0;
    public static int countElite=0;
    public static int countEvent=0;
    public void reward(Player player){
        ;
    }

    public Episode(int chapter, int levelNum, Player player){
        EpisodeData episodeData =new EpisodeData();
        this.chapterNum=chapter;
        this.levelNum=levelNum;
        //随机生成鬼魂 生成鬼魂类别的概率函数随着章节和层数的变化而变化。
        //当调用Episode构造器时，已知层次和章节，自动生成相应的鬼魂。
        //chapter1&&chapter2:1-7为鬼魂和随机事件等，8为章节奖励。
        //chapter3:1-8均为鬼魂、随机事件等。
        double thresholdEGhost=0.2+(chapter-1)*0.1+levelNum*0.05;
        double thresholdEvent=0.15;
        double randomGhost = Math.random();
        double randomEvent =Math.random();
        //非BOSS关卡
        if (!(((chapter==1||chapter==2)&levelNum==7)||(chapter==3&levelNum==8))) {
            //如果没发生特殊事件，进入鬼魂对战
            if(randomEvent>thresholdEvent){
                //若精英鬼魂概率触发，则与精英鬼魂对战
                if(randomGhost<thresholdEGhost){
                    EliteGhost ghost1= new EliteGhost("精英鬼魂"+levelNum+"|"+chapter,chapter,levelNum);
                    episodeData.ghosts[chapter-1][levelNum-1]=ghost1;
                    this.ghost=ghost1;
                    countElite++;
                }
                //否则与普通鬼魂对战
                else{
                    Normal_Ghost ghost1 = new Normal_Ghost("普通鬼魂"+levelNum+"|"+chapter,chapter,levelNum);
                    episodeData.ghosts[chapter-1][levelNum-1]=ghost1;
                    this.ghost=ghost1;
                    countNormal++;
                }
            }
            else{
                countEvent++;
                //相应的其他事件
                ;
            }
        }
        //BOSS关卡
        else{
            if(chapter==1){

            }
            if(chapter==2){

            }
            if(chapter==3){

            }
            //boss
        }
//        episodeData.episodes[chapter][levelNum].levelNum=levelNum;
//        episodeData.episodes[chapter][levelNum].chapterNum=chapterNum;
    }
}
