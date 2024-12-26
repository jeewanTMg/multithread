package main.java.thread.runnablethread;

public class ExampleThread implements Runnable{

   private  Thread t;
   private String name;
    ExampleThread(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("Thread started to run....");
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + name + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  name + " interrupted.");
        }
        System.out.println("Thread " +  name + " exiting.");
    }

    /*public void start() {
        System.out.println("Starting the thread");
        if(t==null) {
            t = new Thread(this,name);
            t.start();
        }
    }*/
}
