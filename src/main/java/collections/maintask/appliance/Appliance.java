package collections.maintask.appliance;

public abstract class Appliance {
    String name;
    String material;
    String color;
    String work;

    void doTheWork() {
        System.out.println(name + ": do the " + work);
    }
}
