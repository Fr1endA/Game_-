package character.game;

import episode.game.Chapter;

public class Player extends Character implements Skill{
    int chapter;
    int level;
    public Player(String name, int chapter,int level){
        this.name=name;
        this.attack_power=60;
        this.armor=20;
        this.magic_power=15;
        this.magic_resistance=10;
        this.hp=900;
        this.cur_hp=hp;
        this.Type=1;
        this.strengthenRate=0.2;
        this.chapter=chapter;
        this.level=level;
    }
    public void recover(){
        this.cur_hp=hp;
        this.live=1;
    }

    public void skill_Q(Character character) {
        super.skill_Q();

    }




    @Override
    public void damageSkill(Character character) {
        character.cur_hp-=chapter*this.attack_power+level*0.2*attack_power;
    }

    @Override
    public void defenceSkill(Character character) {

    }

    @Override
    public void enhanceSkill(Character character) {
        //如果目标为敌方，减损对方抗性
        //如果目标为自己，提升自身抗性
        if(character instanceof Ghost){
            character.armor-=(8+(chapter-1)*0.8+level*strengthenRate*0.6);
        }
        else if(character instanceof Player){
            character.armor+=(8+(chapter-1)*0.8+level*strengthenRate*0.6);
        }
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
    //    public void attack(Character character){
//        character.cur_hp-=this.attack_power  *  (1-character.resistanceRate(character.armor));
//        return;
//    }
}
