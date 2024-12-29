package main.java.thread.java8thread;

public class Employee {
    private String name;
    private String address;
    private String salary;

    private String newJoiner;
    private String learningPending;

    public Employee(String name, String address, String salary, String newJoiner, String learningPending) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.newJoiner = newJoiner;
        this.learningPending = learningPending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNewJoiner() {
        return newJoiner;
    }

    public void setNewJoiner(String newJoiner) {
        this.newJoiner = newJoiner;
    }

    public String getLearningPending() {
        return learningPending;
    }

    public void setLearningPending(String learningPending) {
        this.learningPending = learningPending;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", newJoiner='" + newJoiner + '\'' +
                ", learningPending='" + learningPending + '\'' +
                '}';
    }
}
