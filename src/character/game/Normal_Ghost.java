package character.game;

public class Normal_Ghost extends Ghost{
    public Normal_Ghost(String name, int chapter, int level) {
        super(name, chapter, level);
        this.Type =2;
        this.presenceProbability=0.8-(chapter-1)*0.1-level*0.05;
        this.strengthenRate=0.15+0.04*(level-1);
    }
    public void specialEffect(Character character){
        System.out.println("Action on"+character.name);
    }

    @Override
    public void skill_Q() {
        super.skill_Q();
        //
        this.attack_power*=(1+this.strengthenRate);
    }
}
