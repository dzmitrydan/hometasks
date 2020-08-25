package collections.maintask.appliance;

public abstract class Appliance {
    protected String name;
    protected String material;
    protected String color;
    protected String work;

    public void doTheWork() {
        System.out.println(name + ": do the " + work);
    }
}
