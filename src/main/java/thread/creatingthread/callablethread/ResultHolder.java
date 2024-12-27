package main.java.thread.creatingthread.callablethread;

public class ResultHolder <T>{
    private T t;
   public void setResult(T t) {
        this.t = t;
    }
    public T getResult() {
       return t;
    }
}
