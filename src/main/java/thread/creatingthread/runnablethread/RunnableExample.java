package main.java.thread.creatingthread.runnablethread;

public class RunnableExample {
    public static void main(String[] args) {
        Thread h1 = new Thread(new ExampleThread("t1"));
        h1.start();
        Thread h2 = new Thread(new ExampleThread("t2"));
        h2.start();
    }
}
