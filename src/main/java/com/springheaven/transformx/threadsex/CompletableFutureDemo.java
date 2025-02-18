package com.springheaven.transformx.threadsex;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureDemo {


    public static void main(String[] args) throws InterruptedException {

    //let go asynchronous using Completable future

        CompletableFuture<String> getFname = CompletableFuture.supplyAsync(() -> {
                var completableFuture = new CompletableFutureTest();
                return completableFuture.getFirstName();

        });
        CompletableFuture<String> getLastName = CompletableFuture.supplyAsync(() -> {
            var completableFuture = new CompletableFutureTest();
            return completableFuture.getLastName();

        });
        //we are asking for the value but its blocking like we are doing the get in future
        var firstName = getFname.thenAccept(System.out::println);
        getLastName.thenAccept(System.out::println);

        System.out.println("Going to be a great software developer its my ultimate goal feeling grateful gratitude love you....");
        Thread.sleep(3000);

    }

}
