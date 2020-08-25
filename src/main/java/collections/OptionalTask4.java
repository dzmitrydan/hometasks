package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptionalTask4 {

    private static final Comparator<String> lineLengthComparator = Comparator.comparingInt(String::length);

    public static void main(String[] args) {

        String verse =
                "The snow is falling,\n" +
                        "The wind is blowing,\n" +
                        "The ground is white\n" +
                        "All day and night.\n";

        List<String> lines = Arrays.asList(verse.split("\n"));

        System.out.println(lines);

        Collections.sort(lines, lineLengthComparator);

        System.out.println(lines);

    }
}
