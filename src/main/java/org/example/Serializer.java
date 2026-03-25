package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

    private static String fileName = "MP1.bin";

    public static void save(List<Worker> workers) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(workers);
            System.out.printf("List saved");
        } catch (Exception e) {
            System.out.printf(e.getMessage() + " SAVE EXCEPTION");
            throw new RuntimeException(e);
        }
    }

    public static List<Worker> getExtend() {
        File file  = new File(fileName);
        if (!file.exists()) return new ArrayList<>();

        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(fileName));
            return (List<Worker>) objectOutputStream.readObject();
        } catch (Exception e) {
            System.out.printf(e.getMessage() + " LOAD EXCEPTION");
            throw new RuntimeException();
        }
    }
}
