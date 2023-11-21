package com.itvdn.javaProfessional.ex_001_serialization.serializationWithObj;

import java.io.Serializable;

public class Car implements Serializable {
    int price;
    String model;
    Engine engine;

    Car(int price, String model, Engine engine) {
        this.price = price;//aggregation
        this.model = model;
        this.engine = engine;
    }
}

class Engine implements Serializable{
    int power;

    Engine(int power) {
        this.power = power;
    }
}
