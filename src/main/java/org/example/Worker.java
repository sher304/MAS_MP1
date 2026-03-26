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
    private static List<Worker> extent = new ArrayList<>();
    public Worker(String name, String surname,
                  Date hireDate, Optional<Date> terminDate, String certificate) {
        super(name, surname);
        if(certificate.isEmpty()) throw  new IllegalArgumentException("At least one Certificate needed ");
        this.hireDate = hireDate;
        this.terminDate = terminDate.orElse(null);
        this.certifications.add(certificate);
        this.extent.add(this);
    }

    public int workingYears() {
        Date currentDate = new Date();
        long diff = currentDate.getTime() - hireDate.getTime();
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Optional<Date> getTerminDate() {
        return Optional.ofNullable(this.terminDate);
    }

    public void setTerminDate(Optional<Date> terminDate) {
        this.terminDate = terminDate.orElse(null);
    }

    public double calculateBonus() {
        return baseMinimumSalary * 0.25;
    }

    public double calculateBonus(double xg) {
        if(xg == 0) throw new IllegalArgumentException("Bonus xg should be more than 0");
        return  baseMinimumSalary * 0.25 * xg;
    }

    public static List<Worker> getExtent() {
        return  extent;
    }

    public static void setExtend(List<Worker> workersExtent) {
        extent = workersExtent;
    }

    @Override
    public String toString() {
        return " Worker Name: "
                + this.name + " Surname "
                + this.surname + " Hire Date: "
                + this.hireDate + " Termin Date: "
                + this.getTerminDate().map(date -> date.toString()).orElse("Has no termin date") + " Certifications: "
                + certifications.toString();
    }
}
