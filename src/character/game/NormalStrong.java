package character.game;

import java.text.DecimalFormat;

public class NormalStrong extends Normal_Ghost implements Skill{
    public NormalStrong(String name, int chapter, int level) {
        super(name, chapter, level);
    }
    private int Qtimes=3;
    int QcurTime = Qtimes;
    private int Wtimes=3;
    int WcurTime=Wtimes;
    private int Etimes=3;
    int EcurTime=Etimes;

    @Override
    public void skill_Q() {
        if(QcurTime>0){
            super.skill_Q();
            enhanceSkill(this);
        }
        else{
            System.out.println("The skillQ limited-times have run out!");
            //重放
        }
        QcurTime--;
    }

    @Override
    public void skill_W() {
        if(WcurTime>0){
            super.skill_W();
            heal(this);
        }
        else{
            System.out.println("The skillQ limited-times have run out!");
            //重放
        }
        WcurTime--;
    }

    public void skill_E(Character character) {
        if(EcurTime>0){
            super.skill_E();
            damageSkill(character);
        }
        else{
            System.out.println("The skillQ limited-times have run out!");
            //重放
        }
        EcurTime--;
    }

    @Override
    public void damageSkill(Character character) {
        double damage=0.6*chapter*this.attack_power  * (1-character.resistanceRate(character.armor) )+2*level;
        //将damage转化为两位小数输出
        damage=Double.parseDouble(new DecimalFormat("#.00").format(damage));
        System.out.println(this.name+" inflicted "+damage+" damage on "+character.name);
        character.cur_hp-=damage;
        if(character.cur_hp<=0){
            character.die();
        }
    }

    @Override
    public void defenceSkill(Character character) {

    }

    @Override
    public void enhanceSkill(Character character) {
        this.armor*=(1+this.strengthenRate);
        this.hp*=(1+this.strengthenRate);
        this.magic_resistance*=(1+this.strengthenRate);
    }

    @Override
    public void imitateSkill(Character character1, Character character2) {

    }

    @Override
    public void debuff(Character character) {

    }

    @Override
    public void recoverCd(Character character) {

    }

    @Override
    public void heal(Character character) {
        double heal= this.strengthenRate*2*(this.hp-this.cur_hp);
        this.cur_hp+=heal;
        System.out.println(this.name+" has recovered hp:"+heal);
    }
}
