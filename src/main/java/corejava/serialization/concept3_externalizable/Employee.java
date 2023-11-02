package corejava.serialization.concept3_externalizable;

import java.io.*;

public class Employee implements Externalizable {
    private String name;
    private int id;
    transient private int salary;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name + "xyz");
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Read in the same order as written
        name = (String)in.readObject();
        if(!name.endsWith("xyz")) {
            throw new IOException("Corrupt Data");
        }
        name = name.substring(0, name.length() - 3);

        id = in.readInt();
    }


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
