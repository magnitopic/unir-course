package com.alaparic.carregistry.model;

public class Vehicle {
    String brand;
    String model;
    int year;
    Integer id;


    // constructor
    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static void startEngine() {
        System.out.println("Engine started");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // methods
    public static void accelerate(int speed) {
        System.out.println("Accelerating");
    }

    public static void brake(int speed) {
        System.out.println("Breaking");
    }

}
