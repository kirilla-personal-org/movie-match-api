package ru.afanasyev.moviematch.app.ipr.locks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        Runnable action = () -> System.out.println("Start!");
        CyclicBarrier berrier = new CyclicBarrier(3, action);
        Runnable task = () -> {
            try {
                // Ожидается пока все потоки встанут в await()
                berrier.await();
                System.out.println("Finished");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println("Limit: " + berrier.getParties());
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}
