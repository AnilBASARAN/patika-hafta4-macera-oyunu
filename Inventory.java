public class Inventory {
    private Weapons weapon;
    private Armors armors;
    public Inventory() {
        // YAPILACAK NOT: yün yelek yerine , samuray için ayrı knight için ayrı default elbiseler yap, bunları samuray, knight sınıflarından al
        // eğer buraya this.player açıp samuray new yaparsan, ona alacağın kıyafetlerle game den seçtiğin samuray aynı olur mu? kıyafet aldıkça güncellenir mi?
        this.weapon = new Weapons("Yumruk",0,0,0);
        this.armors = new Armors("Yün Yelek",0,0,0);
    }

    public Weapons getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }
}
