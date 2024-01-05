import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public boolean isAwardTaken = false;


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
        System.out.println("Şu an buradasınız :  " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor  !");
        System.out.print(" <S>avaş veya <K>aç :  ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {

           if(combat(obsNumber)){
               System.out.println(this.getName() + "tüm düşmanları yendiniz !");
               return true;
           }

        }

        if(this.getPlayer().getHealth() < 0){
            System.out.println("Öldünüz  !");
        }

        return true;
    }



    public boolean combat(int obsNumber) {
        for (int i = 1; i < obsNumber; i++) {
            playerStats();
            obstacleStats();
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.print("<V>ur veya <K>aç  :   ");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
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


            }
        }
        return false;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println( this.getObstacle().getName() +" Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }
    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getWeaponName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmors().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println(("Bloklama :  " + this.getPlayer().getInventory().getArmors().getArmor()));
        System.out.println("Para : " + this.getPlayer().getMoney());

    }

    public void obstacleStats() {
        System.out.println(this.getObstacle().getName() + "  Değerleri");
        System.out.println("-----------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());

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


}


