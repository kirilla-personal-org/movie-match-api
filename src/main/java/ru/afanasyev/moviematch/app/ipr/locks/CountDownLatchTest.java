package ru.afanasyev.moviematch.app.ipr.locks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CountDownLatchTest {
    public static void main(String[] args) {
        Locking locking = new Locking();
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
        List<Thread> workers = Stream
            .generate(() -> new Thread(() -> locking.countDownLatch(outputScraper)))
            .limit(100)
            .toList();

        workers.forEach(Thread::start);
        locking.await();
        outputScraper.add("Latch released");

        for (int i = 0; i < 100; i++) {
            assert outputScraper.get(i).equals("Counted down");
        }
        assert outputScraper.get(100).equals("Latch released");
    }
}
