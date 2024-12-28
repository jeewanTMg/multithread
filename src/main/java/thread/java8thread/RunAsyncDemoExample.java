package main.java.thread.java8thread;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsyncDemoExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
   RunAsyncDemoExample runAsyncDemoExample = new RunAsyncDemoExample();
    runAsyncDemoExample.saveEmployees();
    }

    public Void saveEmployees() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                List<Employee> listOfAllEmployee = getAllEmploye();
                System.out.println("Thread: "+ Thread.currentThread().getName());
                listOfAllEmployee.stream().forEach(employee -> System.out.println(employee.toString()));
            }
        });
        return completableFuture.get();
    }

    public Void saveEmployeesW() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                List<Employee> listOfAllEmployee = getAllEmploye();
                System.out.println("Thread: "+ Thread.currentThread().getName());
                listOfAllEmployee.stream().forEach(employee -> System.out.println(employee.toString()));
        });
        return completableFuture.get();
    }

    public List<Employee> getAllEmploye() {
        List<Employee> allEmployee = new LinkedList<>();
        Employee firstEmployee = new Employee("java","New York","12000");
        Employee firstEmployee1 = new Employee("programming","Salt Lake City","12000");
        Employee firstEmployee2 = new Employee("language","Dallas","12000");
        Employee firstEmployee3 = new Employee("java","Ohio","12000");
        allEmployee.add(firstEmployee);
        allEmployee.add(firstEmployee1);
        allEmployee.add(firstEmployee2);
        allEmployee.add(firstEmployee3);

        return allEmployee;
    }


}
