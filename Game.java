import java.util.Scanner;
public class  Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz  :  ");
        //String playerName = input.nextLine();
        Player player = new Player("Anil");
        System.out.println(player.getName()+" Hoşgeldin");
        System.out.println("Olaylar gelişecek olm , adaya hoşgeldin");
        System.out.println("Lütfen  bir karakter seç");
        player.selectChar();
    }
}
