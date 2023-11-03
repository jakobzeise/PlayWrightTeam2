package day4;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Stream;

public class LambdaExpressions {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jakob", "Alice", "Bob");
        // forEach takes a function as an argument
        names.forEach(argument -> System.out.println(argument));

        // Functional Interface -> 1 abstract Method
        names.stream().filter(String::isEmpty);

        List<String> namesFiltered = new ArrayList<>();
        for (String s : names) {
            if (!s.isEmpty()) {
                namesFiltered.add(s);
            }
        }

        // Functional Programming -> say what you want but not how
        // Declarative Programming -> say what you want and how you want it to happen

        List<Integer> list = Stream
                .generate(() -> new Random().nextInt(0, 100))
                .limit(100)
                .filter(integer -> integer % 3 == 0 && integer % 5 == 0)
                .toList();

        // Predicate takes an argument and returns a boolean






        //"Jakob", "Alice", "Bob"

        // % 3 || 5

        // 45 -> 45
        // 5 -> 4
        // 6 -> 6
        // 8 -> 8

        // f(x) -> y

        // anonymous
        List<Integer> list1 = list.stream()
                .map(LambdaExpressions::doubleValue)
                .toList();

        List<Integer> list2 = list.stream()
                .map(s -> s * 2)
                .toList();



        // Method reference

        System.out.println(list);
        System.out.println(list1);

    }
    public static int doubleValue(int value) {
        return value * 2;
    }

    public static int generateNumber () {
        return 5;
    }
}
