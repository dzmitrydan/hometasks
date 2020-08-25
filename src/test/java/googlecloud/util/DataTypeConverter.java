package googlecloud.util;

public class DataTypeConverter {

    public static double stringToDouble(String number) {
        String string = number.replaceAll("( per.+month)", "");
        string.replaceAll("[^0-9.]", "");
        return Double.parseDouble(string.replaceAll("[^0-9.]", ""));
    }

}
