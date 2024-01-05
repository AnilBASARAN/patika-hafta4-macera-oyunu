public class Samurai extends GameChar {
    private int id = 0;
    public Samurai(){

    }
    public Samurai(String name,int damage, int health, int money) {
        super(name,damage,health,money);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
