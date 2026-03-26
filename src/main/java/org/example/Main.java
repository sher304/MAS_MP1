package org.example;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Load Extend ");
        List<Worker> extend = Serializer.getExtend();
        Worker.setExtend(extend);

        System.out.printf(Worker.getExtent().size() + " Extend load successfully");

        Date date1 = new Date(112, 8, 3);
        Date date2 = new Date(114, 3, 2);

        if (Worker.getExtent().isEmpty()) {
            Worker bill = new Worker("Bill", "Salmon", date1, Optional.empty(), "COMPTIA Sec+");
            Worker sam = new Worker("Sam", "Bolt", date1, Optional.of(date2), "Marketing Comm");
        }

        for (Worker w: Worker.getExtent()) {
            System.out.println(w.toString());
            System.out.println(w.workingYears() + " Working years");
        }
        System.out.println("Static salary: " + Worker.baseMinimumSalary);

        Serializer.save(Worker.getExtent());
    }
}