public  class SafeHouse extends NormalLocation{
    public static int id;
    public SafeHouse(){

    }

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız yenilendi.");
        System.out.println("----------------------------");
        return true;
    }


}
