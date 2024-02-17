package com.database;

import com.database.person.PersonRequest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DatabaseRunner {
    private static final int NUM_THREADS=100000;
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
//            System.out.println("Загрузка потока номер "+i);
            executorService.execute(new PersonRequest());
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime-startTime;
        System.out.println("Время выполнения программы: " + executionTime + " миллисекунд");
//        executorService.awaitTermination(10, TimeUnit.MINUTES);
    }
}
