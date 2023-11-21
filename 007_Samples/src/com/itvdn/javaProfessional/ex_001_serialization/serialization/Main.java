package com.itvdn.javaProfessional.ex_001_serialization.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт класу файл та вказуємо файл
        Path path =
                Paths.get("./src/com/itvdn/javaProfessional/ex_001_serialization/serialization/Vehicle.dat");
        Car bmw = new Car(5000, "BMW");

        try (FileOutputStream fos = new FileOutputStream(path.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // Серіалізуємо об'єкт Car у байт-код
            oos.writeObject(bmw);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            throw new IOException();
        } catch (IOException e) {

        }
    }
}
