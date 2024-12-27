package main.java.thread.creatingthread.callablethread;

import java.util.List;
import java.util.concurrent.*;

public class CallableThreadExamples {

      public static  Callable<String> returnData() {
          return new Callable<String>() {
              @Override
              public String call() throws Exception {
                  return "java";
              }
          };
      }

        public static Callable<String> returnData1(){
          return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Programming Language";
            }
        };


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> data =executorService.submit((returnData()));
        String returnData = data.get();
        System.out.println(returnData);


    }
}
