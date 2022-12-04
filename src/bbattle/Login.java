package bbattle;

import character.game.Player;

import java.util.Scanner;

public class Login {
    public Player createRole(){
        System.out.println("欢迎来到酆都夜游录，为你的角色起个名字吧");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        Player role =new Player(name);
        System.out.println("hello "+name+"！欢迎来到酆都夜游录！！！");

        return role;
    }
    public void load(){
        createRole();
        //load_in_game;
    }
}
