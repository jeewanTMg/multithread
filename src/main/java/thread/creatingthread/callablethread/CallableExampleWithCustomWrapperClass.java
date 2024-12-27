package main.java.thread.creatingthread.callablethread;

import java.util.concurrent.Callable;

public class CallableExampleWithCustomWrapperClass {
    public static void main(String[] args) throws InterruptedException {
        ResultHolder<Integer> recordData = new ResultHolder<>();

        Callable<Integer> dataReturnFromCallable = ()-> {
           int result =12;
           recordData.setResult(result);
           return result;
        };

        Thread dataFromCallable = new Thread(()->{
            try {
                dataReturnFromCallable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        dataFromCallable.start();
        dataFromCallable.join();
        System.out.println("This is the result "+recordData.getResult());
    }
}
