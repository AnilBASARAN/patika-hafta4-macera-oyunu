public class ToolStore extends NormalLocation{

    public ToolStore(){
    }

    public ToolStore(Player player) {
        super(player, "Eşya Dükkanı");
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
                buyArmor();
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

    public void buyArmor(){
        int selectArmor;
        boolean isSelectCaseValid;
        do {
            System.out.print("Bir Zırh Seçiniz:  ");
            selectArmor = Location.input.nextInt();
            isSelectCaseValid = (selectArmor>=1 && selectArmor <= Weapons.weapons().length);
            if(!isSelectCaseValid) System.out.println("Lütfen 1 ile 3 arasında bir değer girin.");
        }while(!isSelectCaseValid) ;

        Armors selectedArmor = Armors.getWeaponById(selectArmor);




        if(selectedArmor.getPrice()>this.getPlayer().getMoney())System.out.println("Yetersiz Bakiye");
        else{
            System.out.println("---------------------------------------------------");
            System.out.println(selectedArmor.getName()+ " Alındı");
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
            System.out.println("Güncel bakiyeniz : "+this.getPlayer().getMoney());

            System.out.println("Önceki silahınız : "+getPlayer().getWeaponName());

            this.getPlayer().getInventory().setArmors(selectedArmor);

            System.out.println("Güncel silahınız : "+getPlayer().getWeaponName());

            System.out.println("Önceki zırhınız : "+getPlayer().getArmorName());

            this.getPlayer().getInventory().setArmors(selectedArmor);

            System.out.println("Güncel zırhınız : "+getPlayer().getArmorName());

            System.out.println("---------------------------------------------------");


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
        System.out.println("------Silahlar-----");
        for( Armors w : Armors.armors() ){
            System.out.println("ID: "+w.getId()+ " "+ w.getName()+ "  Zırh :  " + w.getArmor() + "  Para  : " + w.getPrice());

        }

    }


}
