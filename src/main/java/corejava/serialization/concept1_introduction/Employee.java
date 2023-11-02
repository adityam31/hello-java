package corejava.serialization.concept1_introduction;

import java.io.Serializable;


/*
 * If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface. \
 * Serializable in java is a marker interface and has no fields or methods to implement.
 * It’s like an Opt-In process through which we make our classes serializable.
 */
public class Employee implements Serializable {
    private String name;
    private int id;

    //If you want an object property to be not serialized to stream,
    // you can use transient keyword
    transient private int salary;


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
