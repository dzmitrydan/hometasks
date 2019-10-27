package collections.maintask.appliance;

public class ElectricalAppliance extends Appliance implements ElectricityConsumption {

    String name;
    String material;
    String color;
    String work;
    int power;

    public ElectricalAppliance(String name, String material, String color, String work, int power) {
        this.name = name;
        this.material = material;
        this.color = color;
        this.work = work;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void getElectricity() {

    }

    @Override
    void doTheWork() {
        super.doTheWork();
    }
}
