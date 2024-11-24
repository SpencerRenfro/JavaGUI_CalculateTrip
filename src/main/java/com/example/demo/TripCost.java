// Spencer Renfro
//Project3
// 11-24-2024
package com.example.demo;

import java.util.Objects;

public final class TripCost {

    private double fuelCost;
    private double distance;
    private double fuelEfficiency;
    private final int numberOfDays;
    private final double foodCost;
    private final double hotelCost;
    private final int attractions;

    //combo box selections
    private final String unitForDistance;
    private final String unitForFuelCost;
    private final String unitForEfficiency;

    public TripCost(double fuelCost, double distance, double fuelEfficiency,
                    int numberOfDays, double foodCost, double hotelCost,
                    int attractions, String unitForDistance, String unitForFuelCost,
                    String unitForEfficiency)

    {
        this.fuelCost = fuelCost;
        this.distance = distance;
        this.fuelEfficiency = fuelEfficiency;
        this.numberOfDays = numberOfDays;
        this.foodCost = foodCost;
        this.hotelCost = hotelCost;
        this.attractions = attractions;
        this.unitForDistance = unitForDistance;
        this.unitForFuelCost = unitForFuelCost;
        this.unitForEfficiency = unitForEfficiency;
    }

    public double gasolineCost() {
        System.out.println("gas price: " + ( distance / fuelEfficiency) * fuelCost);
        return ( distance / fuelEfficiency) * fuelCost;
    }
    public double hotel_and_foodCost() {
        System.out.println("hotel and food cost: " + (foodCost + hotelCost) * numberOfDays);
        return numberOfDays == 0 ? foodCost + hotelCost : (foodCost + hotelCost) * numberOfDays;
    }
    public double totalCost() {
        // Convert miles to kilometers if needed
        if (Objects.equals(unitForDistance, "miles") && Objects.equals(unitForEfficiency, "kilometers/liter")) {
            distance *= 1.60934; // Convert miles to kilometers
        }

        // Ensure fuel efficiency remains consistent
        if (Objects.equals(unitForEfficiency, "miles/gallon") && Objects.equals(unitForDistance, "kilometers")) {
            fuelEfficiency *= 0.425144; // Convert mpg to km/L
        }

        // Fuel cost consistency
        if (Objects.equals(unitForFuelCost, "dollars/gallons")) {
            fuelCost /= 3.78541; // Convert price per gallon to price per liter
        }

        // Debugging output to confirm values
        System.out.println("Distance: " + distance + " " + unitForDistance);
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " " + unitForEfficiency);
        System.out.println("Fuel Cost: $" + fuelCost + " " + unitForFuelCost);


//        System.out.println("total cost: " + Math.round((gasolineCost() + hotel_and_foodCost() + attractions) * 100.0) / 100.0);
        return Math.round((gasolineCost() + hotel_and_foodCost() + attractions) * 100.0) / 100.0;
    }




}
