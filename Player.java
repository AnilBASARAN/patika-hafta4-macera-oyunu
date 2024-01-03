import java.util.Scanner;
import java.util.Arrays;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }



public void selectChar() {

    GameChar[] charList = {new Samurai(), new Knight(), new Archer()};

    System.out.println("Karakterler");
    System.out.println("-----------------------------");
    int count = 0;
    for (GameChar gameChar : charList) {
        if (gameChar.getName().split("").length <= 4)
            System.out.println("ID: "+(++count)+" Karakter:" + gameChar.getName() + "   " + "\t" + "Hasar :" + gameChar.getDamage() + "\t" + "Sağlık: " + gameChar.getHealth() + "\t" + "Para: " + gameChar.getMoney());
        else
            System.out.println("ID: "+(++count)+" Karakter:" + gameChar.getName() + "\t" + "Hasar :" + gameChar.getDamage() + "\t" + "Sağlık: " + gameChar.getHealth() + "\t" + "Para: " + gameChar.getMoney());
    }

    int selectChar;
    boolean isSelectCharBound;
    System.out.println("---------------------");
    System.out.print("Lütfen bir karakter giriniz:  ");
    do {

        selectChar = input.nextInt();
        isSelectCharBound = (selectChar >= 1 && selectChar <= charList.length );
        if(!isSelectCharBound) System.out.println("Lütfen 1 ile "+(charList.length)+" arasında bir sayı giriniz");
    } while (!isSelectCharBound);

    switch (selectChar){
        case 1:
            initPlayer(new Samurai());
            break;
        case 2:
            initPlayer(new Knight() );
            break;
        case 3:
            initPlayer(new Archer());

    }

    System.out.println(charList[selectChar-1].getName()+" Karakterini seçtiniz!");
    System.out.println(charList[selectChar-1]);

}



    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());

}


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
