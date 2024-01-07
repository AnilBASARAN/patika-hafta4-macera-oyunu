public  class SafeHouse extends NormalLocation{


    public SafeHouse(){

    }

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız doluyor...");
        System.out.println("Canınız" + this.getPlayer().getHealth()+"'den "+this.getPlayer().getDefaultHealth()+"'a çıktı");

        if(this.getPlayer().getHealth() != this.getPlayer().getDefaultHealth() ) getPlayer().setHealth(this.getPlayer().getDefaultHealth());

        System.out.println("----------------------------");

        return true;
    }


}
