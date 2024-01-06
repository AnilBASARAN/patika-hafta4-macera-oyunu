public class Cave extends BattleLoc{
    private String resident;


    private String award = "Food";

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(),"Food",3);
        this.resident = "Zombie";
        this.award = "Food";
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }


}
