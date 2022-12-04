package bbattle.game;

import bbattle.Login;
import character.game.*;
import character.game.Character;
import episode.game.Episode;
import episode.game.EpisodeData;

import java.util.Scanner;

public class test_battle {

public void intoCircle(Player player){
    while(true){
        //若点击退出，则退出界面
        if(1!=0){
            break;
        }
    }
}
public void reward(Ghost ghost,Player player){

}
    public static void main(String[] args) {
        new test_battle().testAttack();
//        EliteGhost test_ghost=new EliteGhost("test1",2,3);
//        Player player=new Player("Mr.Fire");
//        test_ghost.showHp();
//        player.attack(test_ghost);
//        test_ghost.showHp();
//        player.attack(test_ghost);
//        test_ghost.showHp();
//        test_ghost.skill_Q();
//        test_ghost.showHp();
//        test_ghost.attack(player);
//        player.showHp();

    }
    public void testAttack(){
        int chapter=1;
        int level=1;
        Login login=new Login();
        Player player=login.createRole();
        Scanner scanner=new Scanner(System.in);
        String choice;
        //游戏循环
        while(true){
            //进入章节
            level=1;
            while(true){
                //进入层次
                Episode episode_Now=new Episode(chapter,level,player);

                //若本轮出现了鬼魂
                while(episode_Now.ghost!=null){
                    //战斗循环
                    player.attack(episode_Now.ghost);
                    episode_Now.ghost.showHp();
                    episode_Now.ghost.attack(player);
                    player.showHp();

                    if(player.live==0){
                        intoCircle(player);
                        player.recover();
                        break;
                    }
                    else if(episode_Now.ghost.live==0){
                        //根据相应的鬼魂，为player提供击败奖励
                        reward(episode_Now.ghost,player);
                        //通关后不可回头，通关记录将存入档案
                        EpisodeData.episodes[chapter-1][level-1]=episode_Now;
                        //是否需要回血？？？
                        //player.recover();
                        break;
                    }
                }
                //若本轮出现了事件
                while(episode_Now.ghost==null){
                    System.out.println("=============发生事件==========="+player.name);
                    //具体事件
                    break;
                }
                level++;
                if(chapter<=2&&level>7){
                    //若chapter1、2 到达第八层
                    //给予章节奖励
                    break;
                }
                else if(chapter==3&&level>8){
                    //游戏结束！恭喜通关
                    System.out.println("精英鬼魂出现次数："+Episode.countElite);
                    System.out.println("普通鬼魂出现次数："+Episode.countNormal);
                    System.out.println("特殊事件出现次数："+Episode.countEvent);
                    return ;
                }
            }
            chapter++;
            if(chapter>3){
                break;
            }

        }
//        for (int i = 1; i <=3; i++) {
//            System.out.println("==========Chapter:"+i+"==========");
//            for (int j = 1; j <=8; j++) {
//                if(i==1&&j==8||i==2&&j==8){
//                    continue;
//                }
//                if(player.live==0){
//                    break;
//                }
//                System.out.println("=========layer"+j+"==========");
//                EliteGhost test_ghost=new EliteGhost("test:layer-"+j+"/chapter-"+i,i,j);
//                test_ghost.attack(player);
//                player.showHp();
//                test_ghost.showHp();
//                player.recover();
//            }
//        }


    }
}
