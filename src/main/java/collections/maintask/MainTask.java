package collections.maintask;

import collections.maintask.appliance.ElectricalAppliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainTask {
    private static int totalPowerConsumption;

    public static void main(String[] args) {

        ArrayList<ElectricalAppliance> listAppliances = new ArrayList<ElectricalAppliance>();
        Collections.addAll(listAppliances,
                new ElectricalAppliance("Microwave", "white", "metal", "food heating", 700),
                new ElectricalAppliance("Toaster", "white", "metal", "food cooking", 900),
                new ElectricalAppliance("Electric Kettle", "red", "plastic", "boil water", 2200),
                new ElectricalAppliance("Washing machine", "silver", "metal", "washing clothes", 230),
                new ElectricalAppliance("Vacuum cleaner", "red", "plastic", "cleaning", 1700),
                new ElectricalAppliance("TV", "black", "plastic", "TV show", 170)
        );

        System.out.println("List of electrical appliances:");
        listAppliances.stream().forEach(p -> System.out.printf("\t %s - %d W \n", p.getName(), p.getPower()));

        System.out.println("Connected electrical appliances:");
        listAppliances.stream().limit(3).forEach(s -> connectingApplianceToOutlet(s));
        System.out.println("\t\t Total power consumption: " + totalPowerConsumption + " W");

        System.out.println("Sorting of electrical appliances by power:");
        listAppliances.stream().sorted(new PowerComparator()).forEach(p -> System.out.printf("\t %s - %d W \n", p.getName(), p.getPower()));

        System.out.println("The devices with a power of less than 1000 W:");
        listAppliances.stream().filter(s -> s.getPower() < 1000).forEach(s -> System.out.printf("\t %s - %d W \n", s.getName(), s.getPower()));
    }

    private static void connectingApplianceToOutlet(ElectricalAppliance appliance) {
        int power = appliance.getPower();
        String name = appliance.getName();
        System.out.printf("\t %s - %d W \n", name, power);
        totalPowerConsumption = totalPowerConsumption + power;
    }
}


class PowerComparator implements Comparator<ElectricalAppliance> {
    public int compare(ElectricalAppliance a, ElectricalAppliance b) {
        return a.getPower() - b.getPower();
    }
}



