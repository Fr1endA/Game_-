package character.game;

public interface Skill {
    //�����Ƿ��ʹ�ã�1Ϊ���ã�0Ϊ������
    int cdType=1;
    //CD�Իغ�Ϊ����
    int cd=2;
    //��ǰcd����

    //һ�غϸü��ܿ�ʹ�õĴ�����

    public void damageSkill(Character character);
    public void defenceSkill(Character character);
    public void enhanceSkill(Character character);
    //character1 ģ��/ʹ��character2�ļ��ܣ�����character2ʹ�á�
    public void imitateSkill(Character character1,Character character2);
    public void debuff(Character character);
    public void recoverCd(Character character);
    public void heal(Character character);
}
