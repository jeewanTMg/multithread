package main.java.thread.java8thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandleInCompletableFuture {
    static CompletableFuture<String> futureData = CompletableFuture.supplyAsync(()->{
        throw new RuntimeException("There is error in the completableFuture when getting value");
    });
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        * USING EXCEPTIONALLY() METHOD TO HANDLE EXCEPTIONS
        * */


        System.out.println(usedHandleMethodForException());
    }


    public String usedExceptionally() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = futureData.exceptionally(ex-> {
            return "UnSucess!!!";
        });

        String result = future1.get();
        System.out.println(result);
        return result;
    }

    public static String usedHandleMethodForException() throws ExecutionException, InterruptedException {
       return futureData.handle((error,handle)->{
            if(error != null) {
                return error;
            } else {
                return handle.getMessage();
            }
        }).get();
    }
}
