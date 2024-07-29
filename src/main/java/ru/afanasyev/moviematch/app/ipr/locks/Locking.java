package ru.afanasyev.moviematch.app.ipr.locks;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Phaser;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntSupplier;

public class Locking {
    //Ситуационные инструменты многопоточности в Java: Lock, CountDownLatch, CyclicBarrier, Phaser, ForkJoin-, Semaphore
    // https://www.baeldung.com/java-concurrent-locks

    //    ReadWriteLock — интерфейс для создания read/write локов. Локи необычайно полезны, когда в системе много операций чтения и мало операций записи
    Lock lock = new ReentrantLock();
    int count = 0;

    // ===================================================================================================================
    // = Locks
    // ===================================================================================================================

    public void lockScenario() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void nonLockScenario() {
        count++;
    }

    // ===================================================================================================================
    // = Count Down Latch
    // ===================================================================================================================

    // Счетчик обратного отчета
    CountDownLatch countDownLatch = new CountDownLatch(100);

    @SneakyThrows
    public void await() {
        countDownLatch.await(3, TimeUnit.SECONDS);
    }

    public void countDownLatch(List<String> outputScraper) {
        countDownLatch.countDown();
        outputScraper.add("Count down");
    }

    // ===================================================================================================================
    // = CyclicBarrier
    // ===================================================================================================================

    CyclicBarrier cyclicBarrier;
    // См. CyclicBarrierTest

    // ===================================================================================================================
    // = ForkJoinPool https://www.baeldung.com/java-semaphore
    // ===================================================================================================================

    // Если в кратце - Пул потоков, с очередью выполнения задач
    // Есть 2 класса которые могут выполнятся в этом пуле. Удобно!
    public int executeInForkPool(List<IntSupplier> suppliers) {
        List<RecursiveSupplier> recursiveSuppliers = new ArrayList<>();
        for (IntSupplier runnable : suppliers) {
            RecursiveSupplier recursiveSupplier = new RecursiveSupplier(runnable);
            recursiveSuppliers.add(recursiveSupplier);
        }

        return ForkJoinTask.invokeAll(recursiveSuppliers).stream()
            .mapToInt(ForkJoinTask::join)
            .sum();
    }

    @RequiredArgsConstructor
    static class RecursiveSupplier extends RecursiveTask<Integer> {
        private final IntSupplier supplier;

        @Override
        protected Integer compute() {
            return supplier.getAsInt();
        }
    }

    // ===================================================================================================================
    // = Semaphore https://www.baeldung.com/java-semaphore
    // ===================================================================================================================

    private Semaphore semaphore = new Semaphore(10);

    boolean tryLogin() {
        System.out.println("loging thread: " + Thread.currentThread().getName());
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

    // ===================================================================================================================
    // = Phaser
    // ===================================================================================================================

    Phaser phaser;

}
