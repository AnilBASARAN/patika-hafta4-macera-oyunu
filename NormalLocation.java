public class NormalLocation extends Location {


    public NormalLocation(){
        super();
    }

    public NormalLocation(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
