public class Armors {
    private String name;
    private int id;
    private int armor;
    private int price;

    public Armors(String name, int id, int armor, int price) {
        this.name = name;
        this.id = id;
        this.armor = armor;
        this.price = price;
    }

    public static Armors [] armors(){
        Armors[] armorsList = new Armors[3];
        armorsList[0] = new Armors("Hafif Zırh",1,1,15);
        armorsList[1] = new Armors("Orta  Zırh ",2,3,25);
        armorsList[2] = new Armors("Ağır  Zırh",3,5,40);
        return armorsList;
    }

    public static Armors getWeaponById(int id){
        return Armors.armors()[id-1];
    }

    public static Armors getArmorObjById(int id){
        for(Armors armor : Armors.armors()){
            if(armor.getId() == id){
                return armor;
            }
        }
        return null;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
