package main.java.thread.java8thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WhyNotFuture {

    /*
    * 1.DisAdvantage cannot forcefully i cannot executed..
    *
    * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<List<Integer>> futureListOfInteger = executorService.submit(()->{
           // if i wait for the future then i cannot force fully complete the future.
            return Arrays.asList(1,2,3,4,5);
        });

        List<Integer> list = futureListOfInteger.get();
        System.out.println(list);


        Future<List<Integer>> futureListOfInteger1 = executorService.submit(()->{
            return Arrays.asList(1,2,3,4,5);
        });
        Future<List<Integer>> futureListOfInteger2 = executorService.submit(()->{
            return Arrays.asList(1,2,3,4,5);
        });
        Future<List<Integer>> futureListOfInteger3 = executorService.submit(()->{
            return Arrays.asList(1,2,3,4,5);
        });

        //If i wanted to combin the futureListOfInteger1, futureListOfInteger2 and futureListOfInteger3
        // then i cannot do it.


        //example if there is exception occure then i cannot control here
        Future<Integer> futureListOfInteger5 = executorService.submit(()->{
            return 10/2;
        });

    }
}
