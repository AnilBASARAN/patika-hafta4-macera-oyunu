import java.util.Objects;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean isEscape;

    public static String visitedBattleFields =":";






    public BattleLoc() {
    }

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }



    @Override

    public boolean onLocation() {

        int obsNumber = this.randomObstacleNumber();
        System.out.println("ŞU AN BURADASINIZ :  " + this.getName().toUpperCase());
        System.out.println("*****************************************");
        System.out.println("*****************************************");

        System.out.println("--------------DİKKATLİ OL!-------------- ");
        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("Burada " + obsNumber + " tane " + this.getObstacle().getName().toUpperCase() + " YAŞIYOR  !");
        String selectCase;
        boolean isSelectCaseValid;
        System.out.print(" <S>avaş veya <K>aç :  ");

        do {
            selectCase = input.nextLine();
            selectCase = selectCase.toUpperCase();
            isSelectCaseValid = (Objects.equals(selectCase, "K") || (Objects.equals(selectCase, "S")));
            if(!isSelectCaseValid) System.out.println("Lütfen S veya K tuşlarından birine basınız.");
        }while(!isSelectCaseValid );


        if (selectCase.equals("S") && combat(obsNumber) && (!isEscape)) {
            System.out.println(this.getName() + "'deki tüm düşmanları yendiniz !");
            if(this.getObstacle().getName().equals("Vampir")) setVisitedBattleFields("Odun ");

            if(this.getObstacle().getName().equals("Ayı")) setVisitedBattleFields("Su ");
            if(this.getObstacle().getName().equals("Zombie")) setVisitedBattleFields("Yemek ");
           //if(this.getObstacle().getName().equals("Yılan")) setVisitedBattleFields("Maden ");
            System.out.println("*******************************");
            if(visitedBattleFields.length() != 1) System.out.println("Toplanan Ganimetler "+visitedBattleFields);
            System.out.println("*******************************");
            return true;
        } else if (selectCase.equals("K")) {
            System.out.println("Erkekliğin 10 da 9 u kaçmaktır");
            return true;
        }


        if(this.getPlayer().getHealth() <= 0){
            System.out.println("    GAME OVER    !");
            return false;
        }

        return true;
    }

    // ödüllerin şansa göre gelme durumu
    public void mineAvard(){
        Random r = new Random();
        int awardChance = r.nextInt(100)+1;
        if(awardChance <= 15){
            weaponAwardChance();
        }
        else if(awardChance <= 30){
            armorAwardChance();
        }
        else if(awardChance <=55) {
            moneyAwardChance();
        }else{
            System.out.println("Maalesef Bir Şey Kazanamadınız");
        }
    }
    // Zırhlara özel metot
    public void armorAwardChance(){
        Random r = new Random();
        int awardChance = r.nextInt(100)+1;
        if(awardChance <= 20){
            getPlayer().getInventory().setArmors(Armors.getArmorObjById(3));
            System.out.println("Ağır Zırh Kazandınız");
        }
        else if(awardChance <=50){
            getPlayer().getInventory().setArmors(Armors.getArmorObjById(2));
            System.out.println("Orta Zırh kazandınız");
        }
        else{
            getPlayer().getInventory().setArmors(Armors.getArmorObjById(1));
            System.out.println("Hafif Zırh Kazandınız");
        }
    }
    // Silahlara özel metot
    public void weaponAwardChance(){
        Random r = new Random();
        int awardChance = r.nextInt(100)+1;
        if(awardChance <= 20){
            getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(3));
            System.out.println("Tüfek Kazandınız");
        }
        else if(awardChance <=50){
            getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(2));
            System.out.println("Kılıç Kazanadınız");
        }
        else{
            getPlayer().getInventory().setWeapon(Weapons.getWeaponObjById(1));
            System.out.println("Tabanca Kazandınız");
        }
    }
    // para kazanmaya özel metot
    public void moneyAwardChance(){
        Random z = new Random();
        int moneyChance = z.nextInt(100)+1;

        if(moneyChance <= 20){
            getPlayer().setMoney(getPlayer().getMoney() + 10);
            System.out.println("10 para kazandınız.");
        }

        else if(moneyChance <=50){
            getPlayer().setMoney(getPlayer().getMoney() + 5);
            System.out.println("5 para kazandınız.");

        }
        else{
            getPlayer().setMoney(getPlayer().getMoney() + 1);
            System.out.println("1 para kazandınız.");

        }
    }

    public String whoseTurn(){

        int chance = (int) (Math.random()*100);

        if(chance > 50){
            System.out.println("Şans "+getPlayer().getName()+" dan yana, "+ getPlayer().getName() +" Vuracak!");
        }else {
            System.out.println("Şans "+getObstacle().getName()+" dan yana, "+ getObstacle().getName()+ " Vuracak!");
        }

        return (chance > 50)? "Şans sizden yana" : "Şans yaratıktan yana";
    }



    public boolean combat(int obsNumber) {
        for (int i = 1; i < obsNumber+1; i++) {

            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){



                String selectCombat;
                boolean isSelectCombatValid;
                System.out.print("<V>ur veya <K>aç  :   ");

                do {
                    selectCombat = input.nextLine();
                    selectCombat = selectCombat.toUpperCase();
                    isSelectCombatValid = (Objects.equals(selectCombat, "V") || (Objects.equals(selectCombat, "K")));
                    if(!isSelectCombatValid) System.out.println("Lütfen V veya K tuşlarından birine basınız.");
                }while (!isSelectCombatValid);

                if (selectCombat.equals("K")) {
                    setEscape(true);
                    System.out.println("Erkekliğin 10 da 9 u kaçmaktır");
                    return true;
                }


                else if(selectCombat.equals("V") && Objects.equals(whoseTurn(), "Şans sizden yana")){
                    System.out.println("Siz vurdunuz");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth() > 0 ){
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmors().getArmor();
                        if(obstacleDamage < 0 ) obstacleDamage = 0;

                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }
                }

                else {
                        System.out.println("Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmors().getArmor();
                        if(obstacleDamage < 0 ) obstacleDamage = 0;
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    if(this.getPlayer().getHealth() > 0 ){
                        System.out.println("Siz vurdunuz");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                    }else {
                        return false;
                    }


                    }

                if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                    System.out.println("######################################################");
                    System.out.println("######################################################");

                    System.out.println(i+ ". Düşmanı YENDİNİZ ! ");
                    System.out.println(this.getObstacle().getAward()+ " para kazandınız  !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    System.out.println("Güncel paranız : "+this.getPlayer().getMoney());
                    System.out.println("######################################################");
                    System.out.println("######################################################");
                    break;
                }
                }


            }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("      ÖLDÜNÜZ!     ");
            return false;
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        if(this.getPlayer().getHealth()<5) System.out.println("CANINIZ KRİTİK SEVİYEDE YAŞAMAK İÇİN KAÇ VE CAN DOLDUR");
        System.out.println( this.getObstacle().getName() +" Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats() {
        System.out.println("----------SİZİN DEĞERLERİNİZ----------");
        System.out.println("######################################################");
        System.out.println("######################################################");
        System.out.println("----------Sağlık : " + this.getPlayer().getHealth()+"----------");
        System.out.println("----------Silah : " + this.getPlayer().getWeaponName()+"----------");
        System.out.println("----------Zırh : " + this.getPlayer().getInventory().getArmors().getName()+"----------");
        System.out.println("----------Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println(("----------Bloklama :  " + this.getPlayer().getInventory().getArmors().getArmor())+"----------");
        System.out.println("----------Para : " + this.getPlayer().getMoney()+"----------");
        System.out.println("######################################################");
        System.out.println( "*****************************************************");
        if(getVisitedBattleFields().split("").length != 1) System.out.println("Toplanan Ganimetler:" + getVisitedBattleFields());
        System.out.println( "****************************************************");

    }

    public void obstacleStats(int i) {
        System.out.println(i+". "+this.getObstacle().getName() + "  DEĞERLERİ");
        System.out.println("------------------------------------------------------");
        System.out.println("######################################################");
        System.out.println("######################################################");
        System.out.println("----------Sağlık : " + this.getObstacle().getHealth()+"----------");
        System.out.println("----------Hasar : " + this.getObstacle().getDamage()+"----------");
        System.out.println("----------Ödül : " + this.getObstacle().getAward()+"----------");
        System.out.println("######################################################");
        System.out.println("######################################################");
        System.out.println();

    }

    public String getVisitedBattleFields() {
        return visitedBattleFields;
    }

    public  void setVisitedBattleFields(String str) {
        if(!getVisitedBattleFields().contains(str))
        this.visitedBattleFields = visitedBattleFields + str ;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


    public boolean isEscape() {
        return isEscape;
    }

    public void setEscape(boolean escape) {
        isEscape = escape;
    }
}


