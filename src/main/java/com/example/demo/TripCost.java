package com.example.demo;

public final class TripCost {

    private double distance;
    private double gasMileage;
    private double gasPrice;
    private double foodCost;
    private double hotelCost;
    private double tripCost;
    private int numberOfDays;
    private int attractions;

    public TripCost(double gasPrice, double distance, double gasMileage) {
        this.gasPrice = gasPrice;
        this.distance = distance;
        this.gasMileage = gasMileage;

    }

    public double gasolineCost() {
        return ( distance /gasMileage ) * gasPrice;
    }


}
