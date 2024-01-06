import java.util.Arrays;
import java.util.Scanner;
public class  Game {

    protected Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz  :  ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+" Hoşgeldin");
        System.out.println("Olaylar gelişecek Altın ağacından paralar fışkıracak ,  Hoşgeldin");

        System.out.println("Lütfen  bir karakter seç");
        player.selectChar();

        SafeHouse safehouse = new SafeHouse(player);
        ToolStore toolStore = new ToolStore(player);
        Cave cave = new Cave(player);

        Forest forest = new Forest(player);
        River river = new River(player);
        Mine mine = new Mine(player);


        Location location = null;
        Location[] locationList = {safehouse,toolStore,cave,forest,river,mine};
        outerloop:

       while (true){

           do {

        //son karar
               String[] locationListObstacles = {"Güvenli ev", "ToolStore", "Zombi", "Vampir", "Ayı","Yılan"};
               String[] locationRewards = {"Can doluyor", "Eşya satın alabilirsin", "Yemek", "Odun", "Su","Maden"};
               player.printPlayerInfo();
               System.out.println("Lokasyonlar");
               System.out.println("----------------------------------------------");
               System.out.println("ID: 0 Çıkış ");

               int count = 0;
               for (Location locations : locationList) {
                   System.out.println();
                   System.out.println("ID: " + (++count) + " Lokasyon : " + locations.getName() + "   " + "\t");

                   if (count == 3 || count == 4 || count == 5 || count == 6)
                       System.out.println("(Ödül :" + locationRewards[count - 1].toString() + ")  (Dikkatli ol ! " + locationList[count - 1].getName() + "'dan " + (locationListObstacles[count - 1].toString()) + " çıkabilir)");

               }

               int selectLocation;
               boolean isSelectCharBound;


               do {
                   System.out.println("--------------------------------------------**---");
                   System.out.print("Lütfen bir lokasyon giriniz:  ");

                   selectLocation = input.nextInt();
                   isSelectCharBound = (selectLocation >= 0 && selectLocation <= locationList.length);
                   if (!isSelectCharBound)
                       System.out.println("Lütfen 0 ile " + (locationList.length) + " arasında bir sayı giriniz");

               } while (!isSelectCharBound);

               if(selectLocation == 0){
                   location = null;
                   System.out.println("Çabuk Vazgeçtin Delikanlı");
               }

               else if (selectLocation == 1){
                   if(cave.getVisitedBattleFields().split("").length==14){
                       System.out.println("KAZANDINIZ TEBRİKLER");
                       return;
                       }
                   location = new SafeHouse(player);
               }

               else if (selectLocation == 2){
                   if(cave.getVisitedBattleFields().split("").length==14){
                       System.out.println("KAZANDINIZ TEBRİKLER");
                       return;
                   }
                   location = new ToolStore(player);
               }

               else if (selectLocation == 3){
                   if (!cave.getVisitedBattleFields().contains("Yemek")) location = new Cave(player);
                   else {
                       System.out.println("GİRİŞ YASAK");
                       continue outerloop;
                   }
               }

               else if (selectLocation == 4){
                   if (!cave.getVisitedBattleFields().contains("Odun")) location = new Forest(player);
                   else {
                       System.out.println("GİRİŞ YASAK");
                       continue outerloop;
                   }
               }
               else if (selectLocation == 5){
                   if (!cave.getVisitedBattleFields().contains("Su")) location = new River(player);
                   else{
                       System.out.println("GİRİŞ YASAK");
                       continue outerloop;
                   }

               }


               System.out.println(locationList[selectLocation - 1].getName() + " Lokasyonunu seçtiniz!");
               System.out.println("------------------**-----------------------------");
               System.out.println();


           }while (location.onLocation());

       }


    }
}
