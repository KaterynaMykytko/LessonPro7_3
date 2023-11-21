package com.itvdn.javaProfessional.ex_001_serialization.serializationWithObj;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Створюємо об'єкт класу файл та вказуємо файл
        File f =
                new File("src/com/itvdn/javaProfessional/ex_001_serialization/serializationWithObj/file2");

        Car c = new Car(5000, "BMW", new Engine(1500));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        // Серіалізуємо об'єкт Car у байт-код
        oos.writeObject(c);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        // Десеріалізуємо об'єкт Car з байт-коду
        Car newCar = (Car)ois.readObject();
        ois.close();
        System.out.println(newCar.price + " " + newCar.model + " " + newCar.engine.power);
    }
}
