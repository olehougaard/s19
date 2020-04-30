package dk.via.mutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class Numbers {
    private static boolean isEven(int n) {
        System.out.println(String.format("Is %d even?", n));
        return n % 2 == 0;
    }

    private static int squared(int n) {
        System.out.println(String.format("%d squared is %d", n, n * n));
        return n * n;
    }

    private static int sumOfEvenNumbersSquaredIterative(List<Integer> numbers) {
        int sum = 0;
        for(Integer number: numbers) {
            if (number % 2 == 0) {
                sum += number * number;
            }
        }
        return sum;
    }

    private static int sumOfEvenNumbersSquared(List<Integer> numbers) {
        return numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
    }

    private static List<Integer> firstNEvenNumbersSquared(List<Integer> numbers, int count) {
        return numbers.stream()
                .filter(n -> isEven(n))
                .map(n -> squared(n))
                .limit(count)
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 20; i++) {
            randomNumbers.add(random.nextInt(10));
        }
        long time = System.currentTimeMillis();
        System.out.println(randomNumbers);
        System.out.println(firstNEvenNumbersSquared(randomNumbers, 5));
        System.out.println(System.currentTimeMillis() - time);
    }
}
