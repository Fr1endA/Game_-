package character.game;

public class Normal_Ghost extends Ghost{
    int chapter;
    int level;
    public Normal_Ghost(String name, int chapter, int level) {

        super(name, chapter, level);
        this.Type =2;
        this.presenceProbability=0.85-(chapter-1)*0.1-level*0.05;
        this.strengthenRate=0.15+0.04*(level-1);
        this.chapter=chapter;
        this.level=level;
    }
    public void specialEffect(Character character){
        System.out.println("Action on"+character.name);
    }

    @Override
    //ÄÜÁ¦ÌáÉı
    public void skill_Q() {
        super.skill_Q();
    }

}
