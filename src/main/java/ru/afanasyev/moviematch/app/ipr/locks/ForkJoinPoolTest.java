package ru.afanasyev.moviematch.app.ipr.locks;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        testInForkPool(); // 1052 ms
        testSimple(); //9106 ms
    }

    private static void testSimple() {
        long time = System.currentTimeMillis();

        int sum = IntStream.range(1, 10)
            .mapToObj(ForkJoinPoolTest::getAsInt)
            .mapToInt(IntSupplier::getAsInt)
            .sum();

        System.out.println(sum);

        System.out.println("spent time: " + (System.currentTimeMillis() - time));
    }

    private static void testInForkPool() {
        long time = System.currentTimeMillis();

        List<IntSupplier> intSuppliers = IntStream.range(1, 10).mapToObj(ForkJoinPoolTest::getAsInt).toList();
        Locking locking = new Locking();
        int sum = locking.executeInForkPool(intSuppliers);

        System.out.println(sum);

        System.out.println("spent time: " + (System.currentTimeMillis() - time));
    }

    private static IntSupplier getAsInt(Integer i) {
        return () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i;
        };
    }
}
