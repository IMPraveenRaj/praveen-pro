package com.springheaven.transformx.gc;

import java.util.ArrayList;
import java.util.List;

public class GCPerformanceTest {
    private static final int OBJECT_COUNT = 10_000_000;  // Number of objects to allocate
    private static final int SLEEP_TIME_MS = 100;        // Sleep time to simulate processing

    public static void main(String[] args) {
        List<byte[]> memoryConsumer = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < OBJECT_COUNT; i++) {
            // Allocate memory dynamically (simulating high-memory operations)
            byte[] block = new byte[1024]; // 1 KB per object
            memoryConsumer.add(block);

            // Occasionally clear some memory to trigger GC
            if (i % 500_000 == 0) {
                memoryConsumer.clear();
                System.gc(); // Suggest GC (not guaranteed to run immediately)
            }

            // Simulate some processing delay
            try {
                Thread.sleep(SLEEP_TIME_MS / OBJECT_COUNT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }
}
