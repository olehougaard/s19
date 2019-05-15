package dk.via.immutable;

import java.util.stream.IntStream;

public class Primes {
    private static boolean isPrime(int n) {
        return n > 1 &&
                IntStream.iterate(2, p -> p + 1)
                .takeWhile(p -> p * p <= n)
                .noneMatch(p -> n % p == 0);
    }












    /**
     * Sums the square roots of numberOfPrimes primes starting with the first prime at least as big as the lowerBound.
     *
     * @param lowerBound if prime, the first prime. If not prime, the lowest larger prime is used.
     * @param numberOfPrimes the number of primes to find.
     * @return the sum of the square roots of the found primes
     */
    private static double sumOfsquareRootsOfPrimes(int lowerBound, int numberOfPrimes) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sumOfsquareRootsOfPrimes(101, 51));
    }
}
