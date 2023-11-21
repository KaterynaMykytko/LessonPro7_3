package com.itvdn.javaProfessional.ex_001_serialization.classWithoutImplements;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Car extends Machine implements Serializable {
    int price;
    String model;
    transient Engine engine;

    Car(int weight, int price, String model, Engine engine) {
        super(weight);
        this.price = price;
        this.model = model;
        this.engine = engine;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            // Все, що можна записуємо звичайним способом
            oos.defaultWriteObject();
            // Те, що нормально записати не можемо, то записуємо безпосередньо через метод
            oos.writeInt(engine.power);
            oos.writeObject(engine.producer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void readObject(ObjectInputStream ois) {
        try {
            // Все, що можна зчитуємо звичайним способом
            ois.defaultReadObject();
            // Те, що записати не можемо нормально, записуємо через метод writeInt()
            this.engine = new Engine(ois.readInt(), (String) ois.readObject());

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Engine {
    int power;
    String producer;

    Engine(int power, String producer) {
        this.power = power;
        this.producer = producer;
    }
}

class Machine {
    // int weight = 100;
    int weight;

    Machine() {

    }

    Machine(int weight) {
        this.weight = weight;
    }
}