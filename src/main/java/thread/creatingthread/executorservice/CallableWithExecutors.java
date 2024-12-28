package main.java.thread.creatingthread.executorservice;

import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class CallableWithExecutors {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Callable<String>> data = new HashSet<>();
        data.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });
        data.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });

       List< Future<String>> futuresDatas = executorService.invokeAll(data);
       for(Future<String>futureData:futuresDatas) {
           System.out.println(futureData.get());
       }

    }

}