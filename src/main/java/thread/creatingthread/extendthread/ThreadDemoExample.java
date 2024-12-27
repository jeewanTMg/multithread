package main.java.thread.creatingthread.extendthread;

public class ThreadDemoExample {
    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample("Jeewan Thread");
        thread1.start();
        ThreadExample thread = new ThreadExample("Random Thread");
        thread.start();
    }
}
