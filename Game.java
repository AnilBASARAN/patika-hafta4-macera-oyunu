import java.util.Arrays;
import java.util.Scanner;
public class  Game {
    protected Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz  :  ");
        //String playerName = input.nextLine();
        Player player = new Player("Atakan Uzun");
        System.out.println(player.getName()+" Hoşgeldin");
        System.out.println("Olaylar gelişecek Altın ağacından paralar fışkıracak ,  Hoşgeldin");

        System.out.println("Lütfen  bir karakter seç");
        player.selectChar();

        SafeHouse safehouse = new SafeHouse(player);
        ToolStore toolStore = new ToolStore(player);
        Cave cave = new Cave(player);
        Forest forest = new Forest(player);
        River river = new River(player);

        Location location = null;
        Location[] locationList = {safehouse,toolStore,cave,forest,river};

        do{


            String [] locationListObstacles = {"Güvenli ev","ToolStore","Zombi","Vampir","Ayı"};
            String [] locationRewards = {"Can doluyor","Eşya satın alabilirsin","Yemek","Odun","Su"};
            player.printPlayerInfo();
            System.out.println("Lokasyonlar");
            System.out.println("----------------------------------------------");
            System.out.println("ID: 0 Çıkış ");

            int count = 0;
            for (Location locations : locationList) {
                System.out.println();
                System.out.println("ID: "+(++count)+" Lokasyon : " + locations.getName()+ "   " + "\t");

                if( count == 3 || count == 4 || count == 5) System.out.println("(Ödül :" + locationRewards[count-1].toString() +")  (Dikkatli ol ! "+locationList[count-1].getName()  +"'dan "+ (locationListObstacles[count-1].toString()) +" çıkabilir)");

            }

            int selectLocation;
            boolean isSelectCharBound;



            do {
                System.out.println("--------------------------------------------**---");
                System.out.print("Lütfen bir lokasyon giriniz:  ");

                selectLocation = input.nextInt();
                isSelectCharBound = (selectLocation >= 0 && selectLocation <= locationList.length );
                if(!isSelectCharBound) System.out.println("Lütfen 0 ile "+(locationList.length)+" arasında bir sayı giriniz");
            } while (!isSelectCharBound);

            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;



            }
            if(location == null){
                System.out.println("Çabuk Vazgeçtin Delikanlı");

                return;
            }
            System.out.println(locationList[selectLocation-1].getName()+" Lokasyonunu seçtiniz!");
            System.out.println("------------------**-----------------------------");
            System.out.println();




        }while (location.onLocation()== true);

    }
}
