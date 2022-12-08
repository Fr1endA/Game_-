package character.game;

public class EliteGhost extends Normal_Ghost implements Skill{
    public EliteGhost(String name, int chapter, int level) {
        super(name, chapter, level);
        this.Type=3;
        this.presenceProbability=0.15+(chapter-1)*0.1+level*0.05;
        this.strengthenRate=0.24+0.08*(level-1);
    }
    @Override
    //基于已损生命值的回血
    public void skill_Q() {
        super.skill_Q();
        heal(this);
    }
    @Override
    //能力提升
    public void skill_W() {
        super.skill_W();
        //能力提升
        enhanceSkill(this);

    }
    //攻击技能
    public void skill_E(Character character) {
        super.skill_E();
        damageSkill(character);
    }
    @Override
    public void damageSkill(Character character) {

    }
    @Override
    public void defenceSkill(Character character) {

    }

    @Override
    public void enhanceSkill(Character character) {

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
        double heal= this.strengthenRate*3*(this.hp-this.cur_hp);
        this.cur_hp+=heal;
        System.out.println(this.name+" has recovered hp:"+heal);
    }


}
