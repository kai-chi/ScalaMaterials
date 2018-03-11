package safari;

public interface Plane extends Vehicle {
    @Override
    default void launch() {
        System.out.println("I'm a plane!");
    }
}
