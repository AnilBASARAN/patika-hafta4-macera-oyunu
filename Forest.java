public class Forest extends BattleLoc {
        private String resident;



    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Firewood",3);
        this.resident = "Vampir";
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }


}
