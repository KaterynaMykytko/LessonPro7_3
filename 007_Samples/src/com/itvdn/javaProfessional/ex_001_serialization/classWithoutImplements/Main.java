package com.itvdn.javaProfessional.ex_001_serialization.classWithoutImplements;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Створюємо об'єкт класу файл та вказуємо файл
        File f = new File("./src/com/itvdn/javaProfessional/ex_001_serialization/classWithoutImplements/file3");
        Car c = new Car(100, 5000, "BMW", new Engine(1500, "MANN"));
        // При десеріалізації робиться виклик конструктора супер класу,
        // значення на 150 не змінює, можна Machie implements Seriazable зробити
        // c.weight = 150;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        // Серіалізуємо об'єкт Car у байт-код
        oos.writeObject(c);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        // Десеріалізуємо об'єкт Car з байт-коду
        // При десеріалізації викликається конструктор суперкласу
        Car newCar = (Car) ois.readObject();
        ois.close();
        System.out.println(newCar.price + " " + newCar.model + " " + newCar.engine.power + " " + newCar.engine.producer + " " + newCar.weight);
    }
}
