package safari;

public class SeaPlane implements Plane, Boat {

    @Override
    public void launch() {
        Boat.super.launch();
    }
}
