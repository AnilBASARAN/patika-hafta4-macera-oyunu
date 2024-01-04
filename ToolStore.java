public class ToolStore extends NormalLocation{
    private int id = 1;
    public ToolStore(){
    }
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean onLocation() {
        System.out.println("------Mağazaya Hoşgeldiniz !------");

        System.out.println("1-Silahlar ");
        System.out.println("2-Zırhlar ");
        System.out.println("3-Çıkış Yap ");
        int selectCase;
        boolean isSelectCaseValid;
        do {
            System.out.print("Seçiminiz:  ");
            selectCase = Location.input.nextInt();
            isSelectCaseValid = (selectCase>=1 && selectCase <= 3);
            if(!isSelectCaseValid) System.out.println("Lütfen 1 ile 3 arasında bir değer girin.");
        }while(!isSelectCaseValid) ;

        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Birdaha bekleriz");
                break;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("------Silahlar-----");
        for( Weapons w : Weapons.weapons() ){
            System.out.println("ID: "+w.getId()+ " "+ w.getName()+ "  Hasar :  " + w.getDamage() + "  Para  : " + w.getPrice());

        }

    }

    public void buyWeapon(){
        int selectWeapon;
        boolean isSelectCaseValid;
        do {
            System.out.print("Bir Silah Seçiniz:  ");
            selectWeapon = Location.input.nextInt();
            isSelectCaseValid = (selectWeapon>=1 && selectWeapon <= Weapons.weapons().length);
            if(!isSelectCaseValid) System.out.println("Lütfen 1 ile 3 arasında bir değer girin.");
        }while(!isSelectCaseValid) ;

        Weapons selectedWeapon = Weapons.getWeaponById(selectWeapon);




        if(selectedWeapon.getPrice()>this.getPlayer().getMoney())System.out.println("Yetersiz Bakiye");
        else{
            System.out.println("---------------------------------------------------");
            System.out.println(selectedWeapon.getName()+ " Alındı");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
            System.out.println("Güncel bakiyeniz : "+this.getPlayer().getMoney());

            System.out.println("Önceki silahınız : "+getPlayer().getInventory().getWeapon().getName());

            this.getPlayer().getInventory().setWeapon(selectedWeapon);

            System.out.println("Güncel silahınız : "+getPlayer().getInventory().getWeapon().getName());

            System.out.println("---------------------------------------------------");


        }
    }

    public void printArmor(){
        System.out.println("Zırhlar");
    }
}
