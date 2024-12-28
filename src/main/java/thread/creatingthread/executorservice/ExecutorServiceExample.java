package main.java.thread.creatingthread.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    /*
    *
    * Implementation	                   Best Use Case
      ThreadPoolExecutor ===============>  General-purpose thread pool for highly configurable concurrent tasks.
      ScheduledThreadPoolExecutor=======>  For scheduling recurring or delayed tasks, like cron jobs.
      ForkJoinPool =====================>  For tasks that can be broken into smaller subtasks and executed in parallel (e.g.,recursive algorithms).
      Executors.newFixedThreadPool======>	When you know the exact number of threads needed and tasks are roughly equal in duration.
      Executors.newCachedThreadPool=====>  For tasks with unpredictable or highly variable execution times.
      Executors.newSingleThreadExecutor=>  When you need sequential task execution with a single thread.
    *
    *
    * */


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Name: "+Thread.currentThread().getName());
                System.out.println("This is Executor service");
            }
        });
        executorService.shutdown();
    }
}
