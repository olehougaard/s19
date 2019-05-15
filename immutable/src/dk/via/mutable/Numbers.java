package dk.via.mutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Numbers {
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static int squared(int n) {
        return n * n;
    }

    private static int sumOfEvenNumbersSquared(List<Integer> numbers) {
        return 0;
    }

    private static List<Integer> firstNEvenNumbersSquared(List<Integer> numbers, int n) {
        return List.of();
    }

    public static void main(String[] args) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 100; i++) {
            randomNumbers.add(random.nextInt());
        }
        long time = System.currentTimeMillis();
        System.out.println(sumOfEvenNumbersSquared(randomNumbers));
        System.out.println(System.currentTimeMillis() - time);
    }
}
