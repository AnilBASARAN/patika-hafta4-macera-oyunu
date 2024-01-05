public class River extends BattleLoc{
    private String resident;



    public void setResident(String resident) {
        this.resident = resident;
    }

    public River(Player player) {
        super(player, "Nehir", new Bear(), "Su",2);
        this.resident = "Ayı";
    }

    public String getResident() {
        return resident;
    }
}
