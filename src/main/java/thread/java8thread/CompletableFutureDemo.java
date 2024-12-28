package main.java.thread.java8thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    /*
    * CompletableFuture: A new era of asynchronous programming
    *
    * Using Asynchronous programming you can write non blocking code where concurrently you can N no
    * Of task in separated thread without blocking main thread.
    *
    * When the task is complete it notifies to the main thread( Whether the task was completed or failed)
    *
    * Why CompletableFuture:
    * ======================
    * There are different ways to implements Aysnchronous programming in java using any of the below mechanisms
    * for example you can used Futures, ExecutorService,Callable interfaces, Thread Pools, etc.
    *
    * 1.it cannot be manually completed
    * 2. Multiple Future cannot be chained together.
    * 3.We can not combine mulitple Futres toghether
    * 4. No proper Exception Handling Mechanism.
    *
    * */


    /*
    *
    * Understing runAsync() Vs SupplyAysnc()
    *
    * runAsync will not return any value
    * SuppplyAsync will return the value.
    *
    * CompletableFutrue.runAysnc(Runnable)j;
    * completableFuture.runAsync(Runnable, Executor)
    *
    * it will take thread from the  ForkJoinPool if you don't provide the executor.
    *
    * CompletableFuture.supplyAsync(Supplier<T>)
    * CompletableFuture.supplyAsync(Supplier<T>, Executor)
    *
    * */

    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("there is delay is complete force fully");


    }
}
