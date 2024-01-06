import java.util.Scanner;

public abstract class Location {
    private static int itemCount;
    private Player player;
    private String name;
    private int id;


    public static Scanner input = new Scanner(System.in);

    public Location(){

    }


    public Location(Player player,String name) {
        this.player = player;
        this.name = name;
        itemCount++;
        this.id = itemCount;

    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id=id;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManuName() {
        return getName();
    }

}
