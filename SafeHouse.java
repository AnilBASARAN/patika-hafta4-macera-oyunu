public  class SafeHouse extends NormalLocation{


    public SafeHouse(){

    }

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");

    }


    @Override
    public boolean onLocation() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("              Güvenli Evdesiniz.          ");
        System.out.println();
        System.out.println("          YENİLENMİŞ HİSSEDİYORSUNUZ          ");
        System.out.println();
        System.out.println();
        if(this.getPlayer().getHealth() != this.getPlayer().getDefaultHealth()) System.out.println("           Canınız " + this.getPlayer().getHealth()+" iken "+this.getPlayer().getDefaultHealth()+" oldu.");

        if(this.getPlayer().getHealth() != this.getPlayer().getDefaultHealth() ) getPlayer().setHealth(this.getPlayer().getDefaultHealth());
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        return true;
    }


}
