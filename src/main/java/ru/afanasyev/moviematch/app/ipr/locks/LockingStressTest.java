package ru.afanasyev.moviematch.app.ipr.locks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class LockingStressTest {
    public static void main(String[] args) {

        int size = 1000;
        System.out.println("nonlocking ->");
        Locking locking = new Locking();
        executeTest(locking, size, locking::nonLockScenario);

        System.out.println("locking ->");
        locking = new Locking();
        executeTest(locking, size, locking::lockScenario);
    }

    private static void executeTest(Locking locking, int size, Runnable nonLockScenario) {
        long time = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            CompletableFuture[] completableFutures = new CompletableFuture[size];
            Executor executor = CompletableFuture.delayedExecutor(1000, TimeUnit.MILLISECONDS);
            for (int i = 0; i < size; i++) {
                completableFutures[i] = CompletableFuture.runAsync(nonLockScenario, executor);
            }
            CompletableFuture.allOf(completableFutures).join();
            System.out.println(locking.count);
        }
        System.out.println("spent time: " + (System.currentTimeMillis() - time));
    }
}
