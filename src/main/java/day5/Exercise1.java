package day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 15, 20, 7, 12, 3, 25));
        numbers.stream()
                .filter(integer -> integer < 10)
                .map(integer -> integer * 2)
                .forEach(System.out::println);


    }
}
