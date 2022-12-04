package character.game;

public class Player extends Character {
    public Player(String name){
        this.name=name;
        this.attack_power=60;
        this.armor=20;
        this.magic_power=15;
        this.magic_resistance=10;
        this.hp=900;
        this.cur_hp=hp;
        this.Type=1;
    }
    public void recover(){
        this.cur_hp=hp;
        this.live=1;
    }
//    public void attack(Character character){
//        character.cur_hp-=this.attack_power  *  (1-character.resistanceRate(character.armor));
//        return;
//    }
}
