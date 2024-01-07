public abstract class  GameChar {
    private String name;
    private int damage;
    private int health;
    private int money;
    private int armor = 0;

    private int defaultHealth;

    public GameChar(){

    }

    public GameChar(String name,int damage, int health, int money) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.defaultHealth = health;
    }

    @Override
    public String toString() {
        return
                "Karakter = " + name +
                " , Hasar = " + damage +
                        " , Zırh = " + armor +

                ", Sağlık = " + health +
                ", Para = " + money;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
