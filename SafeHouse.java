public  class SafeHouse extends NormalLocation{

    public SafeHouse(){

    }

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız yenilendi.");
        if(this.getPlayer().getCharName().equals("Samuray")) getPlayer().setHealth(21);
        if(this.getPlayer().getCharName().equals("Okçu")) getPlayer().setHealth(18);
        if(this.getPlayer().getCharName().equals("Şovalye")) getPlayer().setHealth(24);
        System.out.println("----------------------------");

        return true;
    }


}
