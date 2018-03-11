package safari;

public interface Boat extends Vehicle {

    @Override
    default void launch() {
        System.out.println("I'm a boat!");
    }
}
