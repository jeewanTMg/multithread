package main.java.thread.java8thread;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       getEmployee().stream().forEach(System.out::println);
    }

    public static List<Employee> getEmployee() throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return getAllEmploye();
        }).get();
    }


    public static List<Employee> getAllEmploye() {
        List<Employee> allEmployee = new LinkedList<>();
        Employee firstEmployee = new Employee("java","New York","12000","true","fasle");
        Employee firstEmployee1 = new Employee("programming","Salt Lake City","12000","true","fasle");
        Employee firstEmployee2 = new Employee("language","Dallas","12000","true","fasle");
        Employee firstEmployee3 = new Employee("java","Ohio","12000","true","fasle");
        allEmployee.add(firstEmployee);
        allEmployee.add(firstEmployee1);
        allEmployee.add(firstEmployee2);
        allEmployee.add(firstEmployee3);

        return allEmployee;
    }

}
