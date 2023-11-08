package Homework3;

import java.util.*;

public class Andrei {

    private static void ex1() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 15, 20, 7, 12, 3, 25));

        List<Integer> newNumbers = numbers.stream()
                .filter(arg -> arg < 10)
                .map(arg -> arg * 2)
                .toList();

        System.out.println(newNumbers);
    }

    private static void ex2() {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Fig"));
        Collections.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(strings);
    }

    private static void ex3() {
        ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(2.5, 5.0, 1.5, 4.0, 3.5));
        double sum = doubles.stream().reduce(0d, Double::sum);
        System.out.println(sum);
    }

    private static void ex4() {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Fig"));
        List<String> newStrings = strings.stream()
                .filter(string -> string.startsWith("C"))
                .toList();
        System.out.println(newStrings);
    }
    public static void main(String[] args) {
        ex3();
    }
}
