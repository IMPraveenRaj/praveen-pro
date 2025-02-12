package com.springheaven.transformx.threadsex;

import java.util.concurrent.*;

public class CompletableFuture {


    public String getFirstName(){
        String fname="praveenraj";
        try {
            System.out.println("name of the thread is "+Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return fname;
    }

    public String getLastName(){
        String fname="Mohanraj";
        try {
            System.out.println("name of the thread is "+Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return fname;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture completableFuture = new CompletableFuture();
//        long startTime = System.currentTimeMillis();
//        String firstName = completableFuture.getFirstName();//this is a   blocking call
//        System.out.println(firstName);
//        String lastName = completableFuture.getLastName(); //this is a blocking call
//        System.out.println(lastName);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);

        //let make an async call

        long asyncTime = System.currentTimeMillis();
        Callable<String> getFname = () -> {
          return completableFuture.getFirstName();
        };

        Callable<String> getLname = () -> {
            return completableFuture.getLastName();
        };
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Future<String> fname = executorService.submit(getFname);

        Future<String> lname = executorService.submit(getLname);
        String name= fname.get()+lname.get();
        System.out.println(name);
        long asyncEndTime= System.currentTimeMillis();
        System.out.println(asyncEndTime - asyncTime);
        Thread.sleep(3000);

    }
}
