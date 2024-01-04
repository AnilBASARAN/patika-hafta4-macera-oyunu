import java.util.Scanner;
public class  Game {
    protected Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz  :  ");
        //String playerName = input.nextLine();
        Player player = new Player("Anil");
        System.out.println(player.getName()+" Hoşgeldin");
        System.out.println("Olaylar gelişecek olm , adaya hoşgeldin");
        System.out.println("Lütfen  bir karakter seç");
        player.selectChar();


        Location location = null;
        do{


            Location [] locationList = {new SafeHouse(player), new ToolStore(player)};
            player.printPlayerInfo();
            System.out.println("Lokasyonlar");
            System.out.println("----------------------------------------------");

            int count = 0;
            for (Location locations : locationList) {

                System.out.println("ID: "+(++count)+" Lokasyon : " + locations.getName()+ "   " + "\t");

            }

            int selectLocation;
            boolean isSelectCharBound;
            System.out.println("-----------------------------------------------");
            System.out.print("Lütfen bir lokasyon giriniz:  ");
            do {

                selectLocation = input.nextInt();
                isSelectCharBound = (selectLocation >= 1 && selectLocation <= locationList.length );
                if(!isSelectCharBound) System.out.println("Lütfen 1 ile "+(locationList.length)+" arasında bir sayı giriniz");
            } while (!isSelectCharBound);

            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;


            }

            System.out.println(locationList[selectLocation-1].getName()+" Lokasyonunu seçtiniz!");
            System.out.println("-----------------------------------------------");




        }while (location.onLocation()== true);

    }
}
