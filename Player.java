import java.util.Scanner;
import java.util.Arrays;

public class Player {
    private int damage;
    private int health;

    private  int defaultHealth;
    private int money;
    private String name;
    private String charName;
    private int armor = 0;
    private String [] collectedAwards = new String[3];
    private Scanner input = new Scanner(System.in);

    private Inventory inventory;

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }



        public static <T> boolean isNumber(T number) {
            String[] numbersArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
            String[] numberParts = String.valueOf(number).split("");

            for (String i : numberParts) {
                if (!Arrays.asList(numbersArray).contains(i)) {
                    return false;
                }
            }

            return true;
        }


public void selectChar() {

    GameChar[] charList = {new Samurai("Samuray",5,21,15), new Knight("Şovalye",8,24,5), new Archer( "Okçu",7,18,20)};
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("                  SEÇEBİLECEĞİNİZ KARAKTERLER                       ");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("---**---------------------------------------------------------------");
    int count = 0;
    for (GameChar gameChar : charList) {
        if (gameChar.getName().split("").length <= 4)
            System.out.println("ID: "+(++count)+" Karakter:" + gameChar.getName() + "   " + "\t" + "Hasar :" + gameChar.getDamage() + "\t" + "Sağlık: " + gameChar.getHealth() + "\t" + "Para: " + gameChar.getMoney());
        else
            System.out.println("ID: "+(++count)+" Karakter:" + gameChar.getName() + "\t" + "Hasar :" + gameChar.getDamage() + "\t" + "Sağlık: " + gameChar.getHealth() + "\t" + "Para: " + gameChar.getMoney());
    }



            boolean isselectCharValid;
            String selectCharString;
            int selectChar;
            boolean isselectCharNumber;



    System.out.println("---**-----------------------------------------------------");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.print("                    Lütfen bir karakter giriniz:                 ");


    do {
            do {

                selectCharString = input.nextLine();
                isselectCharNumber = isNumber(selectCharString);
                if(!isselectCharNumber) System.out.println("Lütfen bir sayı giriniz");
            }while (!isselectCharNumber);


        selectChar = Integer.parseInt(selectCharString);
        isselectCharValid = ((selectChar == 1) || (selectChar ==  2) || (selectChar == 3 ));

        if(!isselectCharValid) System.out.println("Lütfen 1 ile "+(charList.length)+" arasında bir sayı giriniz");
    } while (!isselectCharValid);

    switch (selectChar){
        case 1:
            initPlayer(new Samurai("Samuray",5,21,400));
            break;
        case 2:
            initPlayer(new Knight("Şovalye",8,24,5));
            break;
        case 3:
            initPlayer(new Archer( "Okçu",7,18,20));

    }

    System.out.println(charList[selectChar-1].getName()+" Karakterini seçtiniz!");

    System.out.println(charList[selectChar-1]);
    System.out.println("-----------------------------------------------------***-----------");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

}





    public void initPlayer(GameChar gameChar){

        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setName(gameChar.getName());
        this.setCharName(gameChar.getName());
        this.setArmor(gameChar.getArmor());
        this.setDefaultHealth(gameChar.getHealth());

}



    public void  printPlayerInfo(){
        System.out.println("SİZİN GÜNCEL DURUMUNUZ: ");
        System.out.println(
                "Silah = " + this.getWeaponName()+
                        ", Zırh adı = " + this.getArmorName() +
                        ", Hasar = " + this.getTotalDamage() +
                        ", Zırh = " + this.getTotalArmor() +
                ", Sağlık = " + this.getHealth() +
                ", Para = " + this.getMoney());
        if(getHealth()<5 ) System.out.println("CANINIZ KRİTİK SEVİYEDE ! ");
}


public int getTotalDamage(){
    return this.damage + this.getInventory().getWeapon().getDamage();
}

    public int getTotalArmor(){
        return this.armor + this.getInventory().getArmors().getArmor();
    }

    public int getArmor() {
        return armor;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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
        if(health<0){
            health = 0;
        }
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

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getWeaponName(){
        return this.getInventory().getWeapon().getName();
    }
    public String getArmorName(){
        return this.getInventory().getArmors().getName();
    }
}
