package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Worker extends Person implements Serializable {
    public Date hireDate;
    public Date terminDate;
    public List<String> certifications = new ArrayList<>();
    public static int baseMinimumSalary = 52;
    private static List<Worker> extend = new ArrayList<>();
    public Worker(String name, String surname, String pesel,
                  Date hireDate, Date terminDate, String certificate) {
        super(name, surname, pesel);
        if(certificate.isEmpty()) throw  new IllegalArgumentException("At least one Certificate needed ");
        this.hireDate = hireDate;
        this.terminDate = terminDate;
        this.certifications.add(certificate);
        this.extend.add(this);
    }

    public int workingYears() {
        Date currentDate = new Date();
        long diff = currentDate.getTime() - hireDate.getTime();
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }

    public void addNewCertificate(String name) {
        certifications.add(name);
    }

    public void addNewCertificate(String name, Date validDate) {
        this.certifications.add(name + " (Valid until: " + validDate.toString() + ")");
    }

    public static List<Worker> getExtend() {
        return  extend;
    }

    public static void setExtend(List<Worker> workersExtend) {
        extend = workersExtend;
    }

    @Override
    public String toString() {
        return " Worker Name: "
                + this.name + " Surname "
                + this.surname + " Pesel: "
                + this.PESEL + " Hire Date: "
                + this.hireDate + " Certifications: " + certifications.toString();
    }
}
