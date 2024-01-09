import java.util.Arrays;
import java.util.Scanner;
public class  Game {

    protected Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
        System.out.println();
        System.out.println("----------Patika'nın Macera Adasına Hoşgeldiniz !----------");
        System.out.println();
        System.out.println();
        System.out.println("Bu adada sizi türlü tehlikeler bekliyor,  !");
        System.out.println("Okçu , Şovalye veya Samuray olarak maceradan maceraya koşacaksınız !");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");

        System.out.println("Orman, Nehir ve Mağaradaki görevleri tamamla ");
        System.out.println("Tüm Ganimetleri topladığınızda güvenli eve GİT ve  OYUNU KAZAN !");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Savaşacağın karakterleri ve gideceğin lokasyonları");
        System.out.println(" ID sine uygun şekilde RAKAM gir.");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.out.println("--------------------------------------------------------------------");
        System.out.print("lütfen bir isim giriniz  :  ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName()+" Hoşgeldin");
        System.out.println("Türlü tehlike ve maceralarla dolu Karanlıklar ormanına giriş yaptın!");
        System.out.println();
        System.out.println();
        System.out.println("                       BOL ŞANS " + playerName);
        System.out.println();
        System.out.println();

        System.out.println("Lütfen  bir Savaşçı tipi seç ve maceraya başla");
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

       while (player.getHealth() > 0){

           do {

        //son karar
               String[] locationListObstacles = {"Güvenli ev", "ToolStore", "Zombi", "Vampir", "Ayı","Yılan"};
               String[] locationRewards = {"Can doluyor", "Eşya satın alabilirsin", "Yemek", "Odun", "Su","Maden"};
               player.printPlayerInfo();
               System.out.println("                      LOKASYONLAR                     ");
               System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
               System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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
               String selectCharString;
               boolean isselectCharNumber;


               do {
                   System.out.println("-----------------------------------------------------**------------");
                   System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                   System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                   System.out.print("              Lütfen bir lokasyon giriniz:  ");

                   do {

                       selectCharString = input.nextLine();
                       isselectCharNumber = Player.isNumber(selectCharString);
                       if(!isselectCharNumber) System.out.println("Lütfen bir sayı giriniz");
                   }while (!isselectCharNumber);


                   selectLocation = Integer.parseInt(selectCharString);
                   isSelectCharBound = (selectLocation >= 0 && selectLocation <= locationList.length);
                   if (!isSelectCharBound)
                       System.out.println("Lütfen 0 ile " + (locationList.length) + " arasında bir sayı giriniz");

               } while (!isSelectCharBound && player.getHealth() >= 0);

               if(selectLocation == 0){

                   System.out.println(".....Oyundan çıkış yapılıyor....");
                   System.out.println(" İyi günler "+ playerName +", yine bekleriz. ");

                   return;
               }

               else if (selectLocation == 1){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("KAZANDINIZ TEBRİKLER");
                       return;
                       }
                   location = new SafeHouse(player);
               }

               else if (selectLocation == 2){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("TÜM GÖREVLERİ BAŞARIYLA TAMAMLADIN. ");
                       System.out.println("TÜM GANİMETLERİ TOPLADIN. ");
                       System.out.println("OYUNU KAZANMAK İÇİN GÜVENLİ EVE GİT. ");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
                   location = new ToolStore(player);
               }

               else if (selectLocation == 3){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("TÜM GÖREVLERİ BAŞARIYLA TAMAMLADIN. ");
                       System.out.println("TÜM GANİMETLERİ TOPLADIN. ");
                       System.out.println("OYUNU KAZANMAK İÇİN GÜVENLİ EVE GİT. ");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
                   if (!cave.getVisitedBattleFields().contains("Yemek")) location = new Cave(player);
                   else {
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("MAĞAĞRADA YAPILACAK GÖREV KALMADI!!!");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                       continue outerloop;
                   }
               }

               else if (selectLocation == 4){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("TÜM GÖREVLERİ BAŞARIYLA TAMAMLADIN. ");
                       System.out.println("TÜM GANİMETLERİ TOPLADIN. ");
                       System.out.println("OYUNU KAZANMAK İÇİN GÜVENLİ EVE GİT. ");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
                   if (!cave.getVisitedBattleFields().contains("Odun")) location = new Forest(player);
                   else {
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("ORMANDA YAPILACAK GÖREV KALMADI!!!");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
               }
               else if (selectLocation == 5){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("TÜM GÖREVLERİ BAŞARIYLA TAMAMLADIN. ");
                       System.out.println("TÜM GANİMETLERİ TOPLADIN. ");
                       System.out.println("OYUNU KAZANMAK İÇİN GÜVENLİ EVE GİT. ");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
                   if (!cave.getVisitedBattleFields().contains("Su")) location = new River(player);
                   else{
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("NEHİRDE YAPILACAK GÖREV KALMADI!!!");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }

               }
               else if (selectLocation == 6){
                   if(cave.getVisitedBattleFields().split("").length==15){
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("TÜM GÖREVLERİ BAŞARIYLA TAMAMLADIN. ");
                       System.out.println("TÜM GANİMETLERİ TOPLADIN. ");
                       System.out.println("OYUNU KAZANMAK İÇİN GÜVENLİ EVE GİT. ");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                       continue outerloop;
                   }
                   location = new Mine(player);

               }


               if(selectLocation != 0) System.out.println(locationList[selectLocation - 1].getName() + " Lokasyonunu seçtiniz!");

               System.out.println("------------------**-----------------------------");
               System.out.println();


           }while (location.onLocation() );

       }


    }
}
