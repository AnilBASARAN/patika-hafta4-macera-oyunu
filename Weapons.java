public class Weapons {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapons(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons [] weapons(){
        Weapons [] weaponsList = new Weapons[3];
        weaponsList[0] = new Weapons("Tabanca",1,2,5);
        weaponsList[1] = new Weapons("Kılıç  ",2,3,3);
        weaponsList[2] = new Weapons("Tüfek  ",3,7,8);
        return weaponsList;
    }

    public static Weapons getWeaponById(int id){
        return Weapons.weapons()[id-1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
