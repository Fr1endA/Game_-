package character.game;

public interface Skill {
    //技能是否可使用，1为可用，0为不可用
    int cdType=1;
    //CD以回合为计数
    int cd=2;
    //当前cd余量

    //一回合该技能可使用的次数。

    public void damageSkill(Character character);
    public void defenceSkill(Character character);
    public void enhanceSkill(Character character);
    //character1 模仿/使用character2的技能，并对character2使用。
    public void imitateSkill(Character character1,Character character2);
    public void debuff(Character character);
    public void recoverCd(Character character);
    public void heal(Character character);
}
