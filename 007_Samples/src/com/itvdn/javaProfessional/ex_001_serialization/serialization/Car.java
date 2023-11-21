package com.itvdn.javaProfessional.ex_001_serialization.serialization;

import java.io.Serializable;

public class Car implements Serializable {
    private int price;
    private String model;

    Car(int price, String model) {
        this.price = price;
        this.model = model;
    }
}
