package main.java.thread.java8thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureChainDemo {
    /*
    * thenApply(Functions); ==> return the value
    * thenAccept(consumer);==> doesn't return value
    * thenRun(Runnable); ==> doesn't return value
    *
    * */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureChainDemo completableFutureChainDemo = new CompletableFutureChainDemo();
        completableFutureChainDemo.sendRemainderToEmployee();
    }

    //Everything is running in a single main thread and blocking the Async When using thenApply.
    //to run the async then used the thenApplyAsync()
    //thenAcceptAsync()
    public  void sendRemainderToEmployee() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*CompletableFuture<Void> completableFuture = */CompletableFuture.supplyAsync(() -> {
            System.out.println("FetchEmployee " + Thread.currentThread().getName());
            return getAllEmploye();
        },executorService).thenApplyAsync((emps) -> {
            System.out.println("New Joiner: " + Thread.currentThread().getName());
            return emps.stream()
                    .filter(employee -> "true".equals(employee.getNewJoiner()))
                    .collect(Collectors.toList());

        },executorService).thenApplyAsync(employees -> {
            System.out.println("pendinglearning New Employee" + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> "true".equalsIgnoreCase(employee.getLearningPending()))
                    .collect(Collectors.toList());
        },executorService).thenApplyAsync(employees -> {
            System.out.println("Name Of Employee " + Thread.currentThread().getName());
            return employees.stream().map(employee -> employee.getName()).collect(Collectors.toList());
        },executorService).thenAccept((names) -> {
            System.out.println("Email Send: " + Thread.currentThread().getName());
            names.forEach(CompletableFutureChainDemo::sendEmailToNameMention);
        }).get();
  //return completableFuture;
    }

    public static String sendEmailToNameMention(String name) {

        String data = switch (name) {
            case "java","programming", "language" -> "Send Email Sucessfully to: ";
            default -> "Don't found the name";
        };
        System.out.println(data+name);
        return data+name;
    }

    public static List<Employee> getAllEmploye() {
        List<Employee> allEmployee = new LinkedList<>();
        Employee firstEmployee = new Employee("java","New York","12000","true","true");
        Employee firstEmployee1 = new Employee("programming","Salt Lake City","12000","true","true");
        Employee firstEmployee2 = new Employee("language","Dallas","12000","true","true");
        Employee firstEmployee3 = new Employee("java","Ohio","12000","true","true");
        allEmployee.add(firstEmployee);
        allEmployee.add(firstEmployee1);
        allEmployee.add(firstEmployee2);
        allEmployee.add(firstEmployee3);

        return allEmployee;
    }

}
