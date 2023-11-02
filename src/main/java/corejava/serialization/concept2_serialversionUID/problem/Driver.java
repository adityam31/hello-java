package corejava.serialization.concept2_serialversionUID.problem;

import java.io.IOException;

public class Driver {

    public static void main(String[] args) {
        String fileName = "employee_data_2.txt";

//        Employee employee1 = new Employee();
//        employee1.setId(100);
//        employee1.setName("Aditya");
//        employee1.setSalary(50000);
//
//        System.out.println(employee1);
//
//        // Serialize to file
//        try {
//            SerializationUtil.serialize(employee1, fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Deserialize
        try {
            Employee eNew = SerializationUtil.deserialize(fileName);
            System.out.println(eNew);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
