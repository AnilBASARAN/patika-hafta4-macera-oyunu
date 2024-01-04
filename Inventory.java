public class Inventory {
    private Weapons weapon;
    public Inventory() {
        this.weapon = new Weapons("Yumruk",0,0,0);
    }

    public Weapons getWeapon() {
        return weapon;
    }



    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }
}
