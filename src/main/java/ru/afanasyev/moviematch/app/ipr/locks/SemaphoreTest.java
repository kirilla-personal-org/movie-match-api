package ru.afanasyev.moviematch.app.ipr.locks;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SemaphoreTest {
    public static void main(String[] args) {
        test();
    }

    @SneakyThrows
    public static void test() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        Locking locking = new Locking();
        IntStream.range(0, slots)
            .forEach(user -> executorService.execute(locking::tryLogin));

        Thread.sleep(100);
        System.out.println("available slots before logout: " + locking.availableSlots());
        assert locking.availableSlots() == 0;
        System.out.println("can login " + locking.tryLogin());

        IntStream.range(0, slots)
            .forEach(user -> executorService.execute(locking::logout));
        executorService.shutdown();

        Thread.sleep(100);
        System.out.println("available slots after logout: " + locking.availableSlots());
        assert locking.availableSlots() == 10;
        System.out.println("can login " + locking.tryLogin());
    }
}
