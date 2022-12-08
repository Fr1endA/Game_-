package character.game;

import java.text.DecimalFormat;

public class NormalAggressive extends Normal_Ghost implements Skill{

    public NormalAggressive(String name, int chapter, int level) {
        super(name, chapter, level);

    }
    private final int Qtimes=3;
    int QcurTime = Qtimes;
    private final int Wtimes=0;
    int WcurTime=Wtimes;
    private final int Etimes=8;
    int EcurTime=Etimes;

    @Override
    public void skill_Q() {
        if(QcurTime>0){
            super.skill_Q();
            enhanceSkill(this);
        }
        QcurTime--;
    }

    public void skill_E(Character character) {

        if(EcurTime>0){
            super.skill_E();
            damageSkill(character);
        }
        EcurTime--;
    }

    @Override
    public void skill_W() {
        super.skill_W();
    }

    @Override
    public void damageSkill(Character character) {
        double damage=1.2*chapter*this.attack_power  * (1-character.resistanceRate(character.armor) )+2*level;
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
        this.attack_power*=(1+this.strengthenRate);
        this.magic_power*=(1+this.strengthenRate);
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

    }
}
