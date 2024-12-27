package main.java.thread.creatingthread.extendthread;

public class ThreadExample extends Thread{
    private String name;
    private Thread t;
    ThreadExample(String name) {
        this.name= name;
    }

    public void run(){
        System.out.println("Running.....");
        try{
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + name + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  name + " interrupted.");
        }
        System.out.println("Thread " +  name + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  name );
        if (t == null) {
            t = new Thread (this, name);
            t.start ();
        }
    }

}
