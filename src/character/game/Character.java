package character.game;

import java.text.DecimalFormat;

// character.game.Character 中含所有参加对战的角色，包括：玩家、鬼魂（普通和精英）等
public class Character implements Mortal{
    public String name="Untitled";
    public int attack_power=80;
    public int magic_power=30;
    public int armor=30;
    public int magic_resistance=20;
    //由于抗性、攻击增益率等等可能产生浮点伤害，生命值为浮点值
    protected double hp=1000;
    public double cur_hp=hp;
    //Type=0表示未定义，1表示玩家，2表示普通鬼魂，3表示精英鬼魂，4表示Boss
    int Type=0;
    public int live=1;//1代表活着，0代表死亡。
    //强化率
    double strengthenRate=0.1;
    public void attack(){
        System.out.println(this.name+"attacked but no target");

    }
    public void attack(Character character){
        double damage=this.attack_power  * (1-character.resistanceRate(character.armor) );
        //将damage转化为两位小数输出
        damage=Double.parseDouble(new DecimalFormat("#.00").format(damage));
        System.out.println(this.name+" inflicted "+damage+" damage on "+character.name);
        character.cur_hp-=damage;
        if(character.cur_hp<=0){
            character.die();
        }
        return;
    }
    public void defence(){
        System.out.println(this.name+" has alleviated the damage");
    }
    public int die(){
        System.out.println(this.name + " has been slain");
        this.cur_hp=0;
        this.live=0;
        return 1;
    }
    public void showHp(){
        System.out.print(this.name);
        System.out.printf("：%.2f/%.2f\n",this.cur_hp,(float)this.hp);
    }
    public void skill_Q(){
        System.out.println(this.name + " release Q");
    }
    public void skill_W(){
        System.out.println(this.name+ " release W");
    }
    public void skill_E(){
        System.out.println(this.name+" release E");
    }
    public double resistanceRate(int resilience){
        double resistanceRate=0;
        resistanceRate = resilience/(double)(resilience+50);
        return resistanceRate;
    }
   
}
