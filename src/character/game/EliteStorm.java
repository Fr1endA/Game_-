package character.game;

import java.text.DecimalFormat;

public class EliteStorm extends EliteGhost implements Skill{
    public EliteStorm(String name, int chapter, int level) {
        super(name, chapter, level);
    }

    @Override
    public void skill_Q() {
        super.skill_Q();
    }

    @Override
    public void skill_W() {
        super.skill_W();
        enhanceSkill(this);
    }

    @Override
    public void skill_E(Character character) {
        super.skill_E(character);
        damageSkill(character);
    }

    @Override
    public void enhanceSkill(Character character) {
        super.enhanceSkill(character);
        this.attack_power*=(1+1.5*this.strengthenRate);
        this.magic_power*=(1+1.5*this.strengthenRate);

    }

    @Override
    public void damageSkill(Character character) {
        super.damageSkill(character);
        double damage=1.4*chapter*this.attack_power  * (1-character.resistanceRate(character.armor) )+2*level;
        //将damage转化为两位小数输出
        damage=Double.parseDouble(new DecimalFormat("#.00").format(damage));
        System.out.println(this.name+" inflicted "+damage+" damage on "+character.name);
        character.cur_hp-=damage;
        if(character.cur_hp<=0){
            character.die();
        }
    }
}
