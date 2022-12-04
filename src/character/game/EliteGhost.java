package character.game;

public class EliteGhost extends Normal_Ghost{
    public EliteGhost(String name, int chapter, int level) {
        super(name, chapter, level);
        this.Type=3;
        this.presenceProbability=0.2+(chapter-1)*0.1+level*0.05;
        this.strengthenRate=0.24+0.08*(level-1);
    }
    @Override
    public void skill_Q() {
        super.skill_Q();
        //基于已损生命值的回血
        double heal= this.strengthenRate*2*(this.hp-this.cur_hp);
        this.cur_hp+=heal;
        System.out.println(this.name+" has recovered hp:"+heal);
    }
}
