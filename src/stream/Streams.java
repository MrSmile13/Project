package stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Streams {
    public static void main(String[] args) {

        ArrayList<Integer> str = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            str.add(i);
        }

        for(int i = 4; i <= 7; i++) {
            str.add(i);
        }

        str.stream()
                .distinct()
                .filter(x -> x > 5)
                .sorted()
                .mapToDouble(x -> x)
                .forEach(System.out :: println);
//                .average();
//                .count();
//                .sum();
//          System.out.println(xc);
//        System.out.println(Double.toString(xc).substring(0, Double.toString(xc).length() - 2));
    }
}
