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

        System.out.printf(Worker.getExtend().size() + " Extend load successfully");

        Date date1 = new Date(2012, 9, 3);
        Date date2 = new Date(2024, 2, 2);
        Date date3 = new Date(2025, 1, 13);

        if (Worker.getExtend().isEmpty()) {
            Worker bill = new Worker("Bill", "Salmon", "0423123133", date1, null, "COMPTIA Sec+");
            Worker sam = new Worker("Sam", "Bolt", null, date1, date2, "Marketing Comm");
            sam.addNewCertificate("ICS2 CC");
            sam.addNewCertificate("Workshop BA", date3);
        }

        for (Worker w: Worker.getExtend()) {
            System.out.println(w.toString());
            System.out.println(w.workingYears() + " Working years");
        }
        System.out.println("Static salary: " + Worker.baseMinimumSalary);

        Serializer.save(Worker.getExtend());
    }
}